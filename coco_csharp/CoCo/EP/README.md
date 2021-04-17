# Introduction

This C# implementation is a direct port of the Java-based CoCo implementation into C#.
The transformation is straightforward, since C# and Java share many of the same
capabilities.

The only C#-specific capability regards disambiguation of covariant overriding.
The additional code exists in EP.M7I2.Factory:

```
// Need to disambiguate *SPLIT* and *MERGE* points.
EP.M2.Exp<FT> EP.M2.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
EP.M7.Exp<FT> EP.M7.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
EP.I1.Exp<FT> EP.I1.Factory<FT>.convert(EP.Exp<FT> other) { return convert(other); }
```

These extra lines are needed because to override a default method in C# the programmer
has to identify the original method being replaced.

In the testing framework, the test cases for each subsequent evolution must invoke
their prior test cases.

```
CoCo.Tests.M1.TestTemplate<FT> parent = this;
parent.test();
```

This is equivalent to the Java code that directly invokes `M1.TestTemplate.super.test()`, 
but in C# this must be broken up in to two steps. The first introduces a new variable
for the safe upcast of this. The subsequent statement invokes the prior test cases.
Testing uses the standard Xunit libraries.

## Execution

To execute the tests, change directory to the CoCo.Tests folder and execute `dotnet test`.
The `dotnet.exe` executable is found on Windows 10 in `C:\Program Files\dotnet\dotnet.exe`
when the appropriate .NET Framework developer build is installed; on Linux it can be
found in the path of the .NET CORE SDK (such as version 3.1.40x).

# Miscellaneous
