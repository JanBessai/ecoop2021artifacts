# Introduction

The TAPL book explain the context. An oCAML implementation

Include citation to EVF/Castor paper

Demonstrates a whole family of domains that evolve

Starting points can be Nat or bool or floatstring or varapp

arith combines Nat and bool with datatype (check for iszero to support if then else on natural numbers)

varapp combines variables and application of terms 

let adds let bindings to varapp

lambdacalculus extends varapp to add lambda functions

typed replicates entire hierarchy with the addition of types in the syntax trees.

We didn't have to reimplement any of the previous modules because CoCo can easily 
add data to existing data structures. The only other approach that could support
this is Growing Trees in Haskell [paper-ref]. 

Grab image of these domains from their paper.

This is a subset of the EVF case study.

# Modularity issues

The original EVF has modularity violations where  CoCo does not.

Our prettyp print function produces a string whereas theirs has to deal with 
variable binding even when there is no binding available in the compiler hierarchy
currently selected.

# Testing

One interesting feature of the TAPL case study is that the test cases show how
the test classes are composed using composition rather than inheritance. You can
see this in any of the test cases, such as `tapl.arith.ArithTests`:

```
public interface ArithTests<Elem, Tm, UNat> extends tapl.nat.NatTests<Elem, Tm, UNat>, tapl.bool.BoolTests<Elem, Tm> {
    @Override Factory<Elem, Tm, UNat> getFactory();
```

This grants access to the factory via composition instead of "being" the factory itself
through inheritance.

One nice feature of the testing framework is the `ToplevelTests` which is designed to
give each extension the opportunity to ensure they have properly implemented their
respective `convert()` and `getSelf()` methods.

While completing the implementation of these TAPL test cases, we found a defect 
in the EVF case study (`tapl.nat.Succ`) regarding the pretty printing of naturals.

# Miscellaneous

The CoCo implementation has no side effects and uses clone/update functions by design
to stay as close to the functional implementation from EVF and the TAPL book. It is 
not a limitation of CoCo, which could have used setters as demonstrated in the 
mathematical expression domain (in particular, the Truncate operation).
