# Introduction

This Scala implementation is a direct port of the Java-based CoCo implementation into Scala.

The implementation takes advantage of `implicit` capabilities provided by Scala. The top-level
`exp.Factory` trait defines the `convert` method and the Scala compiler calls it when needed.
In the Java solution, the programmer is required to invoke `convert` for type reasons.

```
trait Factory[T] {
  implicit def convert(other:Exp[T]) : Exp[T]
}

```

# EP Violations

None

# Miscellaneous

In `exp.m4` a `BinaryExp` is introduced to support the `Truncate` operation which has the side
effect of truncating the expression tree.

```
trait BinaryExp[T] extends Exp[T] {
  var _left:exp.Exp[T]
  var _right:exp.Exp[T]
  def left:Exp[T] = _left
  def right:Exp[T] = _right

  def truncate(level:Int): Unit = {
    if (level > 1) {
      left.truncate(level-1)
      right.truncate(level-1)
    } else {
      _left = lit(left.eval)
      _right = lit(right.eval)
    }
  }
```

Defining `_left` and `_right` in this fashion enables subsequent evolutions to covariantly
override as needed and continue to support this capability without requiring the business
logic to be duplicated elsewhere.
