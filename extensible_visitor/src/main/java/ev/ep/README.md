# Introduction

This implementation is based on the following publication:

Synthesizing Object-Oriented and Functional Design to Promote Re-use
Shriram Krishnamurthi, Matthias Felleisen, Daniel P. Friedman (1998)
https://dl.acm.org/doi/10.5555/646155.679709

The original paper does not have mutable attributes, and
for our example we include set() methods in each of the data types when they 
are first defined, as per common object-oriented usage.

# EP Violations

## Runtime Exception from dynamic casts

Several operations contain dynamic casts which can lead to runtime
exceptions, when a new operation is invoked on an older data type.

Example: ev.ep.m3.Mult

As new data types are added to the system, their accept methods must
include a dynamic cast which can fail if an older visitor is used. This
can easily happen if (a) any makeOP() method was not properly 
overriding its return type; or (b) the visitor was precompiled and stored
in a third party library.

```
public <R> R accept(Visitor<R> v) {
    return ((VisitorDivdMultNeg<R>) v).visit(this);
}
```
## Duplicated business logic 

The merge evolution (ev.ep.m7i2) was not part of the original paper. To 
implement this merged evolution we have to duplicate some business logic.

Example: ev.ep.m7i2.EvalMerged

Business logic is duplicated in the visitors of successive visitors.

## Miscellaneous

We use default interfaces to implement ev.ep.m6.Eql which was not part of the 
original paper. We do this to avoid boilerplate code. In subsequent merged
branches, these default interfaces need to be extended (ev.ep.m7i2.IsDataTypeMerged)
