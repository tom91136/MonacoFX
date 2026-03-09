import org.typelevel.scalacoptions.ScalacOptions

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val ambient2java = (project in file("."))
	.settings(
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

		)
	)


