Global / onChangedBuildSource := ReloadOnSourceChanges

name   := "sparks"
version:= "0.0.1"

scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:postfixOps",
  "-language:higherKinds",
//  "-Ymacro-annotations",
  "-Ywarn-value-discard",
  "-Ywarn-dead-code",
  "-Ywarn-unused",
  "-Xfatal-warnings",
)

libraryDependencies ++= Seq(
  "com.lihaoyi"       %% "pprint"                   % "0.6.4",
  "com.lihaoyi"       %% "fansi"                    % "0.2.12",
  "com.lihaoyi"       %% "upickle"                  % "1.3.11",
  "org.scalatest"     %% "scalatest-shouldmatchers" % "3.2.7",
  "org.scalatest"     %% "scalatest-funspec"        % "3.2.7",
  "org.scalacheck"    %% "scalacheck"               % "1.15.2", // due to 2.11
)

lazy val common = (project in file("common"))

/** spark 2.3.0 + scala 2.11 */
lazy val spark230s211 = (project in file("spark230s211"))
  .dependsOn(common)

/** spark 2.3.4 + scala 2.11 */
lazy val spark234s211 = (project in file("spark234s211"))
  .dependsOn(common)

/** spark 2.4.7 + scala 2.11 */
lazy val spark247s211 = (project in file("spark247s211"))
  .dependsOn(common)

/** spark 2.4.7 + scala 2.12 */
lazy val spark247s212 = (project in file("spark247s212"))
  .dependsOn(common)

/** spark 3.1.1 + scala 2.12 */
lazy val spark311s212 = (project in file("spark311s212"))
  .dependsOn(common)

lazy val whole = (project in file("."))
  .settings(
    crossScalaVersions := Nil
  )
  .aggregate(
    common,
    spark230s211,
    spark234s211,
    spark247s211,
    spark247s212,
    spark311s212,
  )
