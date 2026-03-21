import org.typelevel.scalacoptions.ScalacOptions

Global / onChangedBuildSource := ReloadOnSourceChanges

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
		// jdk.jsobject removed in JDK 26; org.openjfx:jdk-jsobject provides it
		libraryDependencies ++= (
			if (scala.util.Properties.isJavaAtLeast("26"))
				Seq("org.openjfx" % "jdk-jsobject" % "26")
			else Seq.empty
		),
		libraryDependencies += "org.scalameta" %% "munit" % "1.1.0" % Test,
		libraryDependencies ++= Seq(
			"com.google.code.findbugs" % "jsr305" % "3.0.2",
			"com.vladsch.flexmark" % "flexmark-all" % "0.64.8",
			"org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0",
"com.lihaoyi" %% "pprint" % "0.9.6",
			"com.lihaoyi" %% "upickle" % "4.4.3",
			"org.typelevel" %% "cats-core" % "2.13.0",
			"org.typelevel" %% "mouse" % "1.4.0",
			"org.typelevel" %% "kittens" % "3.5.0",
		),
	)