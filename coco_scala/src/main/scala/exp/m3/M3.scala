package exp.m3

trait Factory[T] extends exp.m2.Factory[T] {
  def mult(left : exp.Exp[T], right : exp.Exp[T]) : exp.Exp[T]
  def neg(inner : exp.Exp[T]) : exp.Exp[T]
  def divd(left : exp.Exp[T], right : exp.Exp[T]) : exp.Exp[T]
}

trait Mult[T] extends exp.m2.Exp[T] {
  def left : exp.Exp[T]
  def right : exp.Exp[T]

  def eval : Double = left.eval * right.eval
  def prettyp : String = String.format("(%s * %s)", left.prettyp, right.prettyp)
}

trait Neg[T] extends exp.m2.Exp[T] {
  def inner : exp.Exp[T]

  def eval : Double = -inner.eval
  def prettyp : String = String.format("(- %s)", inner.prettyp)
}

trait Divd[T] extends exp.m2.Exp[T] {
  def left: exp.Exp[T]
  def right: exp.Exp[T]

  def eval: Double = left.eval / right.eval
  def prettyp: String = String.format("(%s / %s)", left.prettyp, right.prettyp)
}

object finalized {
  import exp.m2.finalized.Exp

  trait Factory extends exp.m3.Factory[Exp] with exp.m2.finalized.Factory {
    override def mult(left: exp.Exp[Exp], right: exp.Exp[Exp]):Exp = new Mult(left, right)
    override def neg(inner: exp.Exp[Exp]):Exp = new Neg(inner)
    override def divd(left: exp.Exp[Exp], right: exp.Exp[Exp]):Exp = new Divd(left, right)
  }

  class Mult(val left:exp.Exp[Exp], val right:exp.Exp[Exp]) extends exp.m3.Mult[Exp] with Exp
  class Neg(val inner:exp.Exp[Exp]) extends exp.m3.Neg[Exp] with Exp
  class Divd(val left:exp.Exp[Exp], val right:exp.Exp[Exp]) extends exp.m3.Divd[Exp] with Exp
}
