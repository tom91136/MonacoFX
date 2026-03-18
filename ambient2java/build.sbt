import org.typelevel.scalacoptions.ScalacOptions
import scala.sys.process._

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val monacoVersion        = settingKey[String]("Monaco editor version to download")
lazy val downloadMonacoTypes  = taskKey[File]("Download Monaco npm package and extract types")
lazy val generateTypedocJson  = taskKey[File]("Generate TypeDoc JSON from Monaco types (may fail for newer versions)")
lazy val runMonacoConversion  = taskKey[File]("Run Monaco type conversion to generate Java sources")

lazy val ambient2java = (project in file("."))
	.settings(
		name := "ambient2java",
		version := "0.1",
		scalaVersion := "3.8.2",
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
			"3.8"
		),
		libraryDependencies ++= Seq(
			"com.google.code.findbugs" % "jsr305" % "3.0.2",

			"com.vladsch.flexmark" % "flexmark-all" % "0.64.8",

			"org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0",

			"com.github.pathikrit" %% "better-files" % "3.9.2",
			"com.lihaoyi" %% "pprint" % "0.9.6",
			"com.lihaoyi" %% "upickle" % "4.4.3",
			"org.typelevel" %% "cats-core" % "2.13.0",
			"org.typelevel" %% "mouse" % "1.4.0",
			"org.typelevel" %% "kittens" % "3.5.0",
		),

		monacoVersion := sys.props.getOrElse("monaco.version", ""),

		downloadMonacoTypes := {
			val log     = streams.value.log
			val version = monacoVersion.value
			if (version.isEmpty) sys.error("Set -Dmonaco.version=<ver> (e.g. sbt -Dmonaco.version=0.55.1 runMonacoConversion)")
			val workDir = target.value / "monaco-download"
			IO.createDirectory(workDir)
			IO.write(
				workDir / "package.json",
				"""{"name":"monaco-editor","version":"1.0.0","private":true}"""
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
			val outputJson = workDir / "typedoc-out.json"
			val stampFile  = workDir / ".typedoc-version"
			val version    = monacoVersion.value

			// Invalidate cached typedoc.json when the Monaco version changes
			val cachedVersion = if (stampFile.exists()) IO.read(stampFile).trim else ""
			if (cachedVersion != version && outputJson.exists()) {
				log.info(s"Monaco version changed ($cachedVersion -> $version), invalidating cached typedoc.json")
				IO.delete(outputJson)
			}

			if (!outputJson.exists()) {
				log.info(s"Installing typedoc@0.28.17, typescript@5.6.3, and monaco-editor@$version into $workDir")
				val installRc = Process(
					Seq("npm", "install", "typedoc@0.28.17", "typescript@5.6.3", s"monaco-editor@$version", "--no-save"),
					workDir
				) ! log
				if (installRc != 0) {
					log.warn(s"typedoc/typescript installation failed with exit code $installRc")
				} else {
					// Monaco 0.55+ bundles its .d.ts with top-level declarations (IPosition,
					// IRange, etc.) that are re-exported via type aliases through editor_main.
					// TypeDoc only documents exported symbols, so these top-level declarations
					// are treated as external and their full definitions are lost.  Fix: use a
					// Node.js script (TypeScript compiler API) to extract top-level names and
					// append `export { ... }` so TypeDoc documents them with full children.
					val patchedDts = workDir / "monaco-patched.d.ts"
					val exportScript = baseDirectory.value / "export-toplevel.mjs"
					log.info(s"Patching $dtsFile -> $patchedDts (exporting top-level declarations for TypeDoc)")
					val patchRc = Process(
						Seq("node", exportScript.getAbsolutePath, dtsFile.getAbsolutePath, patchedDts.getAbsolutePath),
						workDir
					) ! log
					if (patchRc != 0) sys.error(s"export-toplevel.mjs failed with exit code $patchRc")

					IO.write(
						workDir / "tsconfig.json",
						s"""{"compilerOptions":{"target":"ES2020","lib":["ES2020","DOM"],"skipLibCheck":true,"noEmit":true},"files":["${patchedDts.getAbsolutePath}"]}"""
					)
					val typedocBin = workDir / "node_modules" / ".bin" / "typedoc"
					log.info(s"Running typedoc@0.28.17 on monaco-editor@$version to generate $outputJson")
					val rc = Process(
						Seq(
							typedocBin.getAbsolutePath,
							"--json",               outputJson.getAbsolutePath,
							"--entryPoints",        patchedDts.getAbsolutePath,
							"--skipErrorChecking"
						),
						workDir
					) ! log
					if (rc != 0)
						log.warn(s"typedoc exited with $rc --typedoc.json may not have been generated (expected for newer Monaco)")
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
			val r         = (Compile / runner).value
			val cp        = (Compile / fullClasspath).value.files
			IO.createDirectory(outputDir)
			if (jsonFile.exists()) {
				log.info(s"Running TsToJavaAst conversion: $jsonFile -> $outputDir")
				try {
					val result = r.run(
						"net.kurobako.monaco.TsToJavaAst",
						cp,
						Seq(jsonFile.getAbsolutePath, dtsFile.getAbsolutePath, outputDir.getAbsolutePath),
						log
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
	)

lazy val it = (project in file("it"))
	.dependsOn(ambient2java)
	.settings(
		name := "ambient2java-it",
		publish / skip := true,
		scalaVersion := "3.8.2",
		// Point test sources at the existing src/it/scala directory
		Test / scalaSource := baseDirectory.value / ".." / "src" / "it" / "scala",
		fork := true,
		Test / javaOptions ++= {
			val cp = (Test / fullClasspath).value.files.mkString(java.io.File.pathSeparator)
			Seq(
				s"-Dtarget.dir=${(ambient2java / target).value.getAbsolutePath}",
				s"-Dtest.classpath=$cp"
			)
		},
		libraryDependencies ++= Seq(
			"org.scalameta" %% "munit" % "1.2.4",
		),
		Test / unmanagedJars ++= {
			val jsTargetDir = baseDirectory.value / ".." / ".." / "js-support" / "target"
			val jars = (jsTargetDir * "js-support-*.jar").get
			if (jars.isEmpty) sys.error(s"No js-support jar found in $jsTargetDir --run 'mvn package -pl js-support' first")
			jars.map(Attributed.blank)
		},
		libraryDependencies += "org.openjfx" % "javafx-web" % "22.0.1" % Test,
		Test / test := ((Test / test) dependsOn (ambient2java / runMonacoConversion)).value,
	)
