Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val scala211 = "2.11.12"
lazy val scala212 = "2.12.13"
lazy val supportedScalaVersions = List(scala212, scala211)

ThisBuild / organization := "org.alexr"
ThisBuild / version      := "0.0.1"

lazy val common = (project in file("common"))
  .settings(
    name               := "common",
    crossScalaVersions := supportedScalaVersions,
  )

lazy val spark247s211 = (project in file("spark247s211"))
  .dependsOn(common)
  .settings(
    scalaVersion := scala211
  )

lazy val spark247s212 = (project in file("spark247s212"))
  .dependsOn(common)
  .settings(
    scalaVersion := scala212
  )

lazy val whole = (project in file("."))
  .aggregate(
    common,
    spark247s211,
    spark247s212,
  )
  .settings(
    crossScalaVersions := Nil,
  )
