package exp.m7alt2

trait Exp[T] extends exp.m7.Exp[T] with exp.alt1.Exp[T] with Factory[T] {
  override def powBy(other: exp.Exp[T]) : exp.Exp[T] = power(this, other)
  override def multBy(other: exp.Exp[T]) : exp.Exp[T] = mult(this, other)
  def isPower(base : exp.Exp[T], exponent: exp.Exp[T]) : Boolean = false
}

trait Power[T] extends exp.alt2.Power[T] with Factory[T] with Exp[T] with exp.m5.BinaryExp[T] {
  def base: exp.Exp[T] = _left
  def exponent: exp.Exp[T] = _right

  def simplify : exp.Exp[T] = {
    if (exponent.eval == 0) {
      lit(1)
    } else if (exponent.eval == 1) {
      base.simplify
    } else if (base.eval == 0) {
      lit(0)
    } else if (base.eval == 1) {
      lit(1.0)
    } else {
      power(base.simplify, exponent.simplify)
    }
  }

  def collect : List[Double] = base.collect ++ exponent.collect
  def id : Int = 80440
  def eql(that : exp.Exp[T]) : Boolean = that.isPower(base, exponent)
  override def isPower(base : exp.Exp[T], exponent: exp.Exp[T]) : Boolean = base.eql(this.base) && exponent.eql(this.exponent)
}

trait Factory[T] extends exp.alt2.Factory[T] with exp.m7.Factory[T] {
  implicit override def convert(toConvert: exp.Exp[T]) : exp.m7alt2.Exp[T]
}

object finalized {

  trait Exp extends exp.m7alt2.Exp[Exp] with Factory {
    def getSelf: Exp = this
  }

  trait Factory extends exp.m7alt2.Factory[Exp] {
    override def lit(value: Double): Exp = new Lit(value)
    override def add(left: exp.Exp[Exp], right: exp.Exp[Exp]): Exp = new Add(left, right)
    override def sub(left: exp.Exp[Exp], right: exp.Exp[Exp]): Exp = new Sub(left, right)
    override def mult(left: exp.Exp[Exp], right: exp.Exp[Exp]): Exp = new Mult(left, right)
    override def neg(inner: exp.Exp[Exp]): Exp = new Neg(inner)
    override def divd(left: exp.Exp[Exp], right: exp.Exp[Exp]): Exp = new Divd(left, right)
    override def power(base: exp.Exp[Exp], exponent: exp.Exp[Exp]): Exp = new Power(base, exponent)

    implicit override def convert(toConvert: exp.Exp[Exp]): Exp = toConvert.getSelf
  }

  class Lit(val value : Double) extends exp.m7.Lit[Exp] with Exp
  class Add(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m7.Add[Exp] with Exp
  class Sub(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m7.Sub[Exp]with Exp

  class Mult(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m7.Mult[Exp] with Exp
  class Neg(var _inner : exp.Exp[Exp]) extends exp.m7.Neg[Exp] with Exp
  class Divd(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m7.Divd[Exp] with Exp
  class Power(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m7alt2.Power[Exp] with Exp
}
