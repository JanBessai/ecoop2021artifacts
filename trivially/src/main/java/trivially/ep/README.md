# Introduction

This implementation is based on the following publication:

The Expression Problem, Trivially! Yanlin Wang and Bruno C. d. S. Oliveira. (2016)
https://dl.acm.org/doi/10.1145/2889443.2889448

The original paper does not have mutable attributes, and we introduce set() methods
in the trivially.ep.m4 evolution because of the truncate operation defined there.

There are issues with binary and producer methods which become quite noticeable
when attempting to add new data types after an evolution contains these operations.

# EP Violations

## Duplicated Business Logic

Example: trivially.ep.m5.Exp

When a producer method is defined, all Exp* interfaces in subsequent evolutions must
override the method signature. The corresponding data type classes must provide full 
implementations to instantiate new data type classes from the later evolution.

## Unsafe Dynamic Casts

Example: trivially.ep.m5.finalized.Add

With operations that have side effects (i.e., Truncate from evolution m5), the finalized
methods must dynamically cast their parameters to the more specialized type.

```
public void setLeft(trivially.ep.m4.Exp left) { 
  this.left = (Exp) left;
}
```

## Miscellaneous

We use default interfaces to implement the Eql operation in evolution m6, which was not
part of the original paper. We do this to avoid boilerplate code.
