name := "eff"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
   "org.atnos" %% "eff" % "3.0.3",
   "org.atnos" %% "eff-monix" % "3.0.3"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked"
)

// to write types like Reader[String, ?]
addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")

// to get types like Reader[String, ?] (with more than one type parameter) correctly inferred
addCompilerPlugin("com.milessabin" % "si2712fix-plugin_2.11.8" % "1.2.0")
