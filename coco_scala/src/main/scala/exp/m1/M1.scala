package exp.m1

trait Factory[T] extends exp.m0.Factory[T] {
  def sub(left: exp.Exp[T], right: exp.Exp[T]) : exp.Exp[T]
}

trait Sub[T] extends exp.m0.Exp[T] with Factory[T] {
  def left : exp.Exp[T]
  def right : exp.Exp[T]

  def eval: Double = left.eval - right.eval
}

object finalized {
  import exp.m0.finalized.Exp

  trait Factory extends exp.m1.Factory[Exp] with exp.m0.finalized.Factory {
    override def sub(left: exp.Exp[Exp], right: exp.Exp[Exp]) : Exp = new Sub(left, right)
  }

  class Sub(val left: exp.Exp[Exp], val right: exp.Exp[Exp]) extends exp.m1.Sub[Exp] with Exp with Factory
}