package exp.m7

trait Exp[T] extends exp.m6.Exp[T] with Factory[T] {
  def powby(other: exp.Exp[T]) : exp.Exp[T]
}

trait Factory[T] extends exp.m6.Factory[T] {
  implicit override def convert(toConvert : exp.Exp[T]) : exp.m7.Exp[T]
}

trait Lit[T] extends exp.m6.Lit[T] with Exp[T] {
  def powby(exponent : exp.Exp[T]) : exp.Exp[T] = {
    val exponentValue = exponent.eval
    var result : exp.Exp[T] = this
    for ( _ <- math.floor(math.abs(exponentValue)).toInt until 1 by -1) {
      result = mult(result, this)
    }
    if (exponentValue < 0) {
      result = divd(lit(1.0), result)
    }

    convert(result)    // had simply been result
  }
}

trait Add[T] extends exp.m6.Add[T] with Exp[T] {
  // evaluate self and raise that value (as a literal) to the given exponent
  override def powby(exponent: exp.Exp[T]) : exp.Exp[T] = lit(eval).powby(exponent)
}

trait Sub[T] extends exp.m6.Sub[T] with Exp[T] {
  // evaluate self and raise that value (as a literal) to the given exponent
  override def powby(exponent: exp.Exp[T]) : exp.Exp[T] = lit(eval).powby(exponent)
}

trait Mult[T] extends exp.m6.Mult[T] with Exp[T] {
  override def powby(exponent: exp.Exp[T]) : exp.Exp[T] = mult(left.powby(exponent), right.powby(exponent))
}

trait Neg[T] extends exp.m6.Neg[T] with Exp[T] {
  override def powby(exponent: exp.Exp[T]) : exp.Exp[T] = mult(lit(-1).powby(exponent), inner.powby(exponent))
}

trait Divd[T] extends exp.m6.Divd[T] with Exp[T] {
  override def powby(exponent: exp.Exp[T]) : exp.Exp[T] = divd(left.powby(exponent), right.powby(exponent))
}

object finalized {

  trait Exp extends exp.m7.Exp[Exp] with Factory {
    def getSelf : Exp = this
  }

  trait Factory extends exp.m7.Factory[Exp] {
    override def lit(value : Double): Exp = new Lit(value)
    override def add(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Add(left, right)
    override def sub(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Sub(left, right)
    override def mult(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Mult(left, right)
    override def neg(inner : exp.Exp[Exp]): Exp = new Neg(inner)
    override def divd(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Divd(left, right)

    implicit override def convert(toConvert : exp.Exp[Exp]) : Exp = toConvert.getSelf
  }

  class Lit(val value : Double) extends exp.m7.Lit[Exp] with Exp
  class Add(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m7.Add[Exp] with Exp
  class Sub(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m7.Sub[Exp] with Exp
  class Mult(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m7.Mult[Exp] with Exp
  class Neg(var _inner : exp.Exp[Exp]) extends exp.m7.Neg[Exp] with Exp
  class Divd(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m7.Divd[Exp] with Exp
}
