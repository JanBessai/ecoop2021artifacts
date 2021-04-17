# Introduction

The Java implementation of CoCo is our reference implementation.

It relies on standard Java features, including default methods for interfaces, found
in Java 8 and later.

The business logic for each operation is found in default methods in the interfaces
for each successive data type. The actual instantiation of a data type object is
deferred to the finalized classes. The implementation never dynamically cast objects,
so there can be no runtime exceptions in `convert`. The compiler can statically
detect missing operations in the finalized classes. 

# EP Violations

None
