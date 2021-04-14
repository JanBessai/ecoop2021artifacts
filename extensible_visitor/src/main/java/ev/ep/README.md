# Introduction

Synthesizing Object-Oriented and Functional Design to Promote Re-use (1998)

The original paper does not have mutable attributes, and
for this example we include set() methods in each of the data types when they 
are first defined, as per common object-oriented usage.

# EP Violations

## Runtime Exception from dynamic casts
Several operations contain dynamic casts which can lead to runtime
exceptions, when a new operation is invoked on an older data type.

Example: ev.ep.m4.Truncate

If the truncate operation is invoked on earlier data types instantiated
from an earlier evolution, the dynamic cast will fail, causing a runtime
exception:

```
public Exp visit(ev.ep.m0.Lit exp) { return visit((ev.ep.m4.Lit)exp); }
```
## Duplicated business logic 

Example: 
Business logic is duplicated in the visitors of successive visitors.