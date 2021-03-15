val defaultSettings =
  Seq(
    crossPaths := false,
    autoScalaLibrary := false,
    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "junit" % "junit" % "4.12" % "test"
    ),
    testFrameworks := Seq(TestFrameworks.JUnit),
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-v"),
    parallelExecution in Test := false
  )

lazy val shared = Project("shared", file("shared")).settings(defaultSettings)
lazy val coco = Project("coco", file("coco")).settings(defaultSettings).dependsOn(shared)
lazy val extensible_visitor = Project("extensible_visitor", file("extensible_visitor")).settings(defaultSettings).dependsOn(shared)
lazy val oo = Project("oo", file("oo")).settings(defaultSettings).dependsOn(shared)
lazy val trivially = Project("trivially", file("trivially")).settings(defaultSettings).dependsOn(shared)
lazy val vita = Project("vita", file("vita")).settings(defaultSettings).dependsOn(shared)

lazy val benchmarks = Project("benchmarks", file("benchmarks"))
  .settings(
    scalaVersion := "2.13.5",
    libraryDependencies ++= Seq(
      "com.storm-enroute" %% "scalameter" % "0.20" % "test"
    ),
    testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework"),
    logBuffered := false,
    parallelExecution in Test := false,
    Test / classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.Flat
  ).dependsOn(coco, extensible_visitor, oo, trivially, vita)


