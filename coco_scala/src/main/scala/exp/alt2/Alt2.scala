package exp.alt2

trait Factory[T] extends exp.alt1.Factory[T] {
  def power(base: exp.Exp[T], exponent: exp.Exp[T]) : exp.Exp[T]

  /** Covariant Conversion */
  implicit override def convert(toConvert: exp.Exp[T]) : exp.alt1.Exp[T]
}

trait Power[T] extends exp.alt1.Exp[T] with Factory[T] {
  def base: exp.Exp[T]
  def exponent: exp.Exp[T]

  def prettyp: String = String.format("(%s^%s)", base.prettyp, exponent.prettyp)
  def eval: Double = math.pow(base.eval, exponent.eval)
  def multby(other: exp.Exp[T]): exp.Exp[T] = power(base, add(exponent, lit(math.log(other.eval)/math.log(base.eval))))
}

object finalized {
  import exp.alt1.finalized.Exp

  trait Factory extends exp.alt1.finalized.Factory with exp.alt2.Factory[exp.alt1.finalized.Exp] {
    override def power(base: exp.Exp[Exp], exponent: exp.Exp[Exp]): Exp = new Power(base, exponent)
  }

  class Power(val base: exp.Exp[Exp], val exponent: exp.Exp[Exp]) extends exp.alt2.Power[Exp] with Exp with Factory
}
