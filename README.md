# Artifacts for Covariant Conversions (CoCo): A Design Pattern 

This project contains the source code for the CoCo Design Pattern.

# Installation

The project is self-contained and uses the Scala Build Tool (SBT) to compile
and launch all test cases and benchmarks.

You must have a working Java Development Kit (JDK) installation, at least JDK 1.8.
You must also make sure that $JAVA_HOME (or %JAVA_HOME%) is properly set to 
point to your Java installation.

You need to install the Scala Build Tool (https://www.scala-sbt.org/1.x/docs/Setup.html)
which can be downloaded from https://www.scala-sbt.org/download.html. You do not need
administrator privileges to install SBT. Once you have downloaded the MSI file,
execute

```msiexec /a sbt-1.5.0.msi TARGETDIR=SOME-DIRECTORY```

Retrieve the project code from the git repository and open up a command line in the 
top-level directory. Launch `sbt compile` in the directory and wait for the tool to download
all software dependencies. The tool will state "(this may take some time)" and that
is a true statement. This command will compile all source files.

Once all dependencies have been installed, then execute ```sbt test```.