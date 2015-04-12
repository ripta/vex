
lazy val customDependencies = Seq(
	"org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3")

lazy val projectSettings = Seq(
	scalaVersion := "2.11.6",
	organization := "space.armada",
	name         := "vex",
	version      := "0.0.1")

lazy val root = (project in file(".")).
	settings(libraryDependencies ++= customDependencies).
	settings(projectSettings: _*)

