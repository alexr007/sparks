package org.alexr.util

object ScalaVersion {

  private val props = new java.util.Properties
  props.load(getClass.getResourceAsStream("/library.properties"))
  val line: String = "compiled with Scala v." + props.getProperty("version.number")

}
