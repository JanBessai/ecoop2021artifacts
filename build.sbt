val defaultSettings =
  Seq(
    crossPaths := false,
    autoScalaLibrary := false,
    libraryDependencies ++= Seq(
      "net.aichler" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test
    ),
    testOptions += Tests.Argument(jupiterTestFramework, "-v"),
    Test / parallelExecution := false
  )

lazy val shared = Project("shared", file("shared")).settings(defaultSettings)
lazy val coco = Project("coco", file("coco")).settings(defaultSettings).dependsOn(shared)
lazy val extensible_visitor = Project("extensible_visitor", file("extensible_visitor")).settings(defaultSettings).dependsOn(shared)
lazy val oo = Project("oo", file("oo")).settings(defaultSettings).dependsOn(shared)
lazy val trivially = Project("trivially", file("trivially")).settings(defaultSettings).dependsOn(shared)
lazy val interpreter = Project("interpreter", file("interpreter")).settings(defaultSettings).dependsOn(shared)
lazy val tapl = Project("tapl", file("tapl")).settings(defaultSettings)
lazy val dom = Project("dom", file("dom")).settings(defaultSettings)

lazy val benchmarks = Project("benchmarks", file("benchmarks"))
  .settings(
    scalaVersion := "2.13.5",
    libraryDependencies ++= Seq(
      "com.storm-enroute" %% "scalameter" % "0.20" % "test"
    ),
    testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework"),
    logBuffered := false,
    Test / parallelExecution := false,
    Test / classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.Flat
  ).dependsOn(coco_scala, dom_scala, coco, extensible_visitor, oo, trivially, interpreter)

lazy val coco_scala = Project("coco_scala", file("coco_scala"))
  .settings(
    scalaVersion := "2.13.5",
    scalacOptions ++= Seq("-deprecation", "-feature", "-language:implicitConversions"),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    ),
  )

lazy val dom_scala = Project("dom_scala", file("dom_scala"))
  .settings(
    scalaVersion := "2.13.5",
    scalacOptions ++= Seq("-deprecation", "-feature", "-language:implicitConversions"),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    )
  )
