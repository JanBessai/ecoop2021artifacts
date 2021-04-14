package exp.alt1

trait Exp[T] extends exp.m2.Exp[T] with Factory[T] {
  def multBy(other: exp.Exp[T]): exp.Exp[T]
}

trait Factory[T] extends exp.m2.Factory[T] {
  /** Covariant Conversion */
  implicit override def convert(toConvert: exp.Exp[T]) : exp.alt1.Exp[T]
}

trait Lit[T] extends exp.m2.Lit[T] with Exp[T] {
  def multBy(other: exp.Exp[T]) : exp.Exp[T] = {
    val otherValue = other.eval
    var result: exp.Exp[T] = this
    for( _ <- math.floor(math.abs(otherValue)).toInt until 1 by -1) {
      result = add(result, this)
    }
    if (otherValue < 0) {
      result = sub(lit(0.0), result)
    }

    result
  }
}

trait Add[T] extends exp.m2.Add[T] with Exp[T] {
  override def multBy(exponent: exp.Exp[T]): exp.alt1.Exp[T] = add(left.multBy(exponent), right.multBy(exponent))
}

trait Sub[T] extends exp.m2.Sub[T] with Exp[T] {
  override def multBy(exponent: exp.Exp[T]): exp.alt1.Exp[T] = sub(left.multBy(exponent), right.multBy(exponent))
}

object finalized {

  trait Exp extends exp.alt1.Exp[Exp] with Factory {
    def getSelf: Exp = this
  }

  trait Factory extends exp.alt1.Factory[Exp] {
    override def lit(value: Double): Exp = new Lit(value)
    override def add(left: exp.Exp[Exp], right: exp.Exp[Exp]): Exp = new Add(left, right)
    override def sub(left: exp.Exp[Exp], right: exp.Exp[Exp]): Exp = new Sub(left, right)

    /** Covariant Conversion */
    implicit override def convert(toConvert: exp.Exp[Exp]): Exp = toConvert.getSelf
  }

  class Lit(val value: Double) extends Exp with exp.alt1.Lit[Exp]
  class Add(val left: exp.Exp[Exp], val right: exp.Exp[Exp]) extends exp.alt1.Add[Exp] with Exp
  class Sub(val left: exp.Exp[Exp], val right: exp.Exp[Exp]) extends exp.alt1.Sub[Exp] with Exp
}