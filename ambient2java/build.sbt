import org.typelevel.scalacoptions.ScalacOptions

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val ambient2java = (project in file("."))
	.settings(
		addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full),
		addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
		name := "ambient2java",
		version := "0.1",
		scalaVersion := "2.13.12",
		javacOptions ++= Seq(
			"-Xlint:all",
			"-target", "17",
			"-source", "17"),
		(Compile / tpolecatExcludeOptions) ++= ScalacOptions.defaultConsoleExclude,
	    Compile / mainClass := Some("net.kurobako.monaco.TsToJavaAst"),
		scalacOptions ++= Seq(
			"-Ybackend-parallelism", "12",
			"-P:bm4:no-filtering:y",
			"-P:bm4:no-tupling:y",
			"-P:bm4:no-map-id:y",
		),
		//		scalacOptions ++= Seq(
		//			"-opt-inline-from:**",
		//			"-opt:-l:none,_",
		//			"-opt-warnings:-none,_"
		//		),
		libraryDependencies ++= Seq(
			"com.google.code.findbugs" % "jsr305" % "3.0.2",

			"com.vladsch.flexmark" % "flexmark-all" % "0.61.26",

			"org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",

			"com.github.pathikrit" %% "better-files" % "3.8.0",
			//			"com.lihaoyi" %% "fastparse" % "2.2.2",
			"com.lihaoyi" %% "pprint" % "0.5.6",
			"com.lihaoyi" %% "upickle" % "1.1.0",
			"org.jsoup" % "jsoup" % "1.12.1",
			//			"eu.timepit" %% "refined" % "0.9.14",
			//			"eu.timepit" %% "refined-cats" % "0.9.14",
			"org.typelevel" %% "cats-core" % "2.2.0-M1",
			"org.typelevel" %% "mouse" % "0.25",
			"org.typelevel" %% "kittens" % "2.1.0",

		)
	)


