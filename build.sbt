
lazy val customDependencies = Seq(
	"org.specs2" %% "specs2-core" % "3.4" % "test",
	"org.specs2" %% "specs2-matcher-extra" % "3.4" % "test",
	"org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3")

lazy val customResolvers = Seq(
	"scalaz-bintray" at "http://dl.bintray.com/scalaz/releases")

lazy val projectSettings = Seq(
	scalaVersion := "2.11.6",
	organization := "space.armada",
	name         := "vex",
	version      := "0.0.1")

lazy val root = (project in file(".")).
	settings(libraryDependencies ++= customDependencies).
	settings(resolvers ++= customResolvers).
	settings(scalacOptions in Test ++= Seq("-Yrangepos")).
	settings(projectSettings: _*)

