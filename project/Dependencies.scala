import sbt._

object Dependencies
{
  val ScalaVersion = "2.13.10"

  lazy val kindProjector = "org.typelevel" %% "kind-projector" % "0.13.2" cross CrossVersion.full

  lazy val junitJupiterApi = "org.junit.jupiter" % "junit-jupiter-api" % "5.9.3"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.15"

  lazy val pegdown = "org.pegdown" % "pegdown" % "1.6.0"
}