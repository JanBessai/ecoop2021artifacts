## Interpreter Approach

Some Challenging Typing Issues in Object-Oriented Languages
Electronic Notes in Theoretical Computer Science 82 No. 8 (2003)
URL: http://www.elsevier.nl/locate/entcs/volume82.html 
https://cs.pomona.edu/~kim/ftp/WOOD.pdf

# EP Violations

## Runtime Exception from dynamic casts

The Interpreter Design Patterns makes extensive use of dynamic casts.

Example: interpreter.ep.m2.PrettypAdd
```
public String prettyp() {
  return "(" + ((PrettypExp)left).prettyp() + "+" + ((PrettypExp)right).prettyp() + ")";
}
```

It composes the results of invoking prettyp on the left and right arguments, but the
`left` and `right` attributes are inherited from `interpreter.ep.m0.EvalAdd` and so
must be cast.

## Duplication of business logic

Example: interpreter.ep.m5.AstreeIdzExp

When a producer method is defined, all Exp* interfaces in subsequent evolutions must 
override the method signature and the corresponding data type classes (i.e., AstreeIdzAdd) 
must provide full implementations to instantiate new data type classes from the later
evolution.

Omitting any of these overriding methods might cause a runtime exception from the 
repeated dynamic casts necessary throughout the codebase.

## Miscellaneous
