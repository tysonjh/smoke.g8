name := "$name$"

organization := "$org$"

scalaVersion := "2.10.1"

parallelExecution := false

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= Seq(
  "com.mdialog" %% "smoke" % "2.0.1",
  "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

credentials += Credentials(Path.userHome / ".mdialog.credentials")

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "mDialog snapshots" at "http://mdialog.github.com/snapshots/"
)
