import org.typelevel.scalacoptions.ScalacOptions
import scala.sys.process._

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val monacoVersion        = settingKey[String]("Monaco editor version to download")
lazy val downloadMonacoTypes  = taskKey[File]("Download Monaco npm package and extract types")
lazy val generateTypedocJson  = taskKey[File]("Generate TypeDoc JSON from Monaco types (may fail for newer versions)")
lazy val runMonacoConversion  = taskKey[File]("Run Monaco type conversion to generate Java sources")

lazy val ambient2java = (project in file("."))
	.configs(IntegrationTest)
	.settings(
		Defaults.itSettings,
		name := "ambient2java",
		version := "0.1",
		scalaVersion := "3.7.1",
		javacOptions ++= Seq(
			"-parameters",
			"-Xlint:all",
			"-target", "17",
			"-source", "17"),
		scalafmtDetailedError                  := true,
		scalafmtFailOnErrors                   := true,
		Compile / packageDoc / publishArtifact := false,
		Compile / doc / sources                := Seq(),
		(Compile / tpolecatExcludeOptions) ++= ScalacOptions.defaultConsoleExclude,
	    Compile / mainClass := Some("net.kurobako.monaco.TsToJavaAst"),
		scalacOptions ++= Seq(
			"-Xmax-inlines",
			"64",
			"-no-indent",                                 //
			"-Wconf:cat=unchecked:error",                 //
			"-Wconf:name=MatchCaseUnreachable:error",     //
			"-Wconf:name=PatternMatchExhaustivity:error", //
			"-language:noAutoTupling",
			"-source",
			"3.7"
		),
		//		scalacOptions ++= Seq(
		//			"-opt-inline-from:**",
		//			"-opt:-l:none,_",
		//			"-opt-warnings:-none,_"
		//		),
		libraryDependencies ++= Seq(
			"com.google.code.findbugs" % "jsr305" % "3.0.2",

			"com.vladsch.flexmark" % "flexmark-all" % "0.64.8",

			"org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0",

			"com.github.pathikrit" %% "better-files" % "3.9.2",
			//			"com.lihaoyi" %% "fastparse" % "2.2.2",
			"com.lihaoyi" %% "pprint" % "0.9.3",
			"com.lihaoyi" %% "upickle" % "4.2.1",
//			"org.jsoup" % "jsoup" % "1.21.1",
			//			"eu.timepit" %% "refined" % "0.9.14",
			//			"eu.timepit" %% "refined-cats" % "0.9.14",
			"org.typelevel" %% "cats-core" % "2.13.0",
			"org.typelevel" %% "mouse" % "1.3.2",
			"org.typelevel" %% "kittens" % "3.5.0",

			"org.scalameta" %% "munit" % "1.0.4" % IntegrationTest,
		),

		monacoVersion := "0.20.0",
		resolvers += Resolver.mavenLocal,
		libraryDependencies += "net.kurobako" % "monacofx-js" % "0.1.0-SNAPSHOT" % IntegrationTest,

		IntegrationTest / fork := true,

		IntegrationTest / javaOptions ++= {
			val cp = (IntegrationTest / fullClasspath).value.files.mkString(java.io.File.pathSeparator)
			Seq(
				s"-Dproject.dir=${baseDirectory.value.getAbsolutePath}",
				s"-Dtarget.dir=${target.value.getAbsolutePath}",
				s"-Dtest.classpath=$cp"
			)
		},

		downloadMonacoTypes := {
			val log     = streams.value.log
			val version = monacoVersion.value
			val workDir = target.value / "monaco-download"
			IO.createDirectory(workDir)
			IO.write(
				workDir / "package.json",
				"""{"name":"monaco-download","version":"1.0.0","private":true}"""
			)
			log.info(s"Installing monaco-editor@$version into $workDir")
			val rc = Process(Seq("npm", "install", s"monaco-editor@$version", "--no-save"), workDir) ! log
			if (rc != 0) sys.error(s"npm install monaco-editor@$version failed with exit code $rc")
			val monacoDir = workDir / "node_modules" / "monaco-editor"
			val dtsFile1  = monacoDir / "monaco.d.ts"
			val dtsFile2  = monacoDir / "esm" / "vs" / "editor" / "editor.api.d.ts"
			if (dtsFile1.exists()) dtsFile1
			else if (dtsFile2.exists()) dtsFile2
			else sys.error(s"Could not find monaco.d.ts in $monacoDir")
		},

		generateTypedocJson := {
			val log        = streams.value.log
			val dtsFile    = downloadMonacoTypes.value
			val workDir    = target.value / "monaco-download"
			val outputJson = workDir / "typedoc.json"
			val stampFile  = workDir / ".typedoc-version"
			val version    = monacoVersion.value

			// Invalidate cached typedoc.json when the Monaco version changes
			val cachedVersion = if (stampFile.exists()) IO.read(stampFile).trim else ""
			if (cachedVersion != version && outputJson.exists()) {
				log.info(s"Monaco version changed ($cachedVersion -> $version), invalidating cached typedoc.json")
				IO.delete(outputJson)
			}

			if (!outputJson.exists()) {
				log.info(s"Installing typedoc@0.16.11, typescript@3.9.7, and monaco-editor@$version into $workDir")
				val installRc = Process(
					Seq("npm", "install", "typedoc@0.16.11", "typescript@3.9.7", s"monaco-editor@$version", "--no-save"),
					workDir
				) ! log
				if (installRc != 0) {
					log.warn(s"typedoc/typescript installation failed with exit code $installRc")
				} else {
					val typedocBin = workDir / "node_modules" / ".bin" / "typedoc"
					log.info(s"Running typedoc@0.16.11 on monaco-editor@$version to generate $outputJson")
					val rc = Process(
						Seq(
							typedocBin.getAbsolutePath,
							"--json",                outputJson.getAbsolutePath,
							"--mode",                "file",
							"--excludeExternals",
							"--includeDeclarations",
							dtsFile.getAbsolutePath
						),
						workDir
					) ! log
					if (rc != 0)
						log.warn(s"typedoc exited with $rc — typedoc.json may not have been generated (expected for newer Monaco)")
					else
						IO.write(stampFile, version)
				}
			} else {
				log.info(s"TypeDoc JSON for monaco-editor@$version already exists at $outputJson, skipping")
			}
			outputJson
		},

		runMonacoConversion := {
			val log       = streams.value.log
			val jsonFile  = generateTypedocJson.value
			val dtsFile   = downloadMonacoTypes.value
			val outputDir = target.value / "monaco-generated"
			IO.createDirectory(outputDir)
			if (jsonFile.exists()) {
				log.info(s"Running TsToJavaAst conversion: $jsonFile -> $outputDir")
				try {
					val result = (Compile / runner).value.run(
						"net.kurobako.monaco.TsToJavaAst",
						(Compile / fullClasspath).value.files,
						Seq(jsonFile.getAbsolutePath, dtsFile.getAbsolutePath, outputDir.getAbsolutePath),
						streams.value.log
					)
					result.failed.foreach(e => log.warn(s"Conversion failed (expected for newer Monaco): ${e.getMessage}"))
				} catch {
					case e: Exception =>
						log.warn(s"Conversion failed (expected for newer Monaco): ${e.getMessage}")
				}
			} else {
				log.warn(s"Skipping conversion: $jsonFile does not exist (typedoc may have failed)")
			}
			outputDir
		},

		IntegrationTest / test := ((IntegrationTest / test) dependsOn runMonacoConversion).value,
	)


