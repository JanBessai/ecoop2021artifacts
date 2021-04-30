# Introduction

This case study is based on an example from the following book:

   "Types and Programming Languages" (TAPL) 
    Benjamin C. Pierce (2002)
    MIT Press, https://www.cis.upenn.edu/~bcpierce/tapl

Both the Extended Visitor Framework (2017) and CASTOR framework for
extensible generative visitors (2020) reproduce work from the TAPL book. 

The extensive case study demonstrates a whole family of domains that can evolve
to add new features and capabilities. Our TAPL case study is a subset of the EVF/CASTOR
case studies involving the following domains:

* `Nat`, `bool`, `floatstring`, or `varapp`
* `arith` combines `Nat` and `bool` with ability to check for `iszero` to support if
  then else on natural numbers
* `let` combines variables and application of terms
* `lambdacalulus` extends varapp to add lambda functions
* `typed` replicates entire hierarchy with the addition of types in the syntax trees

We didn't have to reimplement any of the previous modules because CoCo can easily 
add data to existing data structures. The only other approach that could support
this is Growing Trees in Haskell (2017). 

# Modularity issues

The original EVF case study has modularity violations where CoCo does not.

In particular, our prettyp print function produces a string whereas theirs has 
to deal with variable binding even when there is no binding available in the
compiler hierarchy currently selected.

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

# References

* EVF: an extensible and expressive visitor framework for programming language reuse.
  Weixin Zhang and Bruno C. d. S. Oliveira (2017).
  In Peter Müller, editor, 31st European Conference on Object789 Oriented Programming, 
  ECOOP 2017, June 19-23, 2017, Barcelona, Spain, volume 74 of LIPIcs, pages 29:1–29:32. 
  Schloss Dagstuhl - Leibniz-Zentrum für Informatik, 2017. 
  URL:https://doi.org/10.4230/LIPIcs.ECOOP.2017.29
  http://dx.doi.org/doi:10.4230/LIPIcs.ECOOP.2017.29
  
* CASTOR: Programming with extensible generative visitors.
  Weixin Zhang and Bruno C. d. S. Oliveira (2020).
  Sci. Comput. Program., 193:102449
  URL: https://doi.org/10.1016/j.scico.2020.102449
  http://dx.doi.org/10.1016/j.scico.2020.102449
  
* Trees that Grow.
  Shayan Najd and Simon Peyton Jones
  Journal of Universal Computer Science, vol. 23, no. 1 (2017), 42-62
  https://www.microsoft.com/en-us/research/publication/trees-that-grow/
