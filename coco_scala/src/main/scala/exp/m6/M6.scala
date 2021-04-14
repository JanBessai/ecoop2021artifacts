package exp.m6

trait Exp[T] extends exp.m5.Exp[T] with Factory[T] {
  override def equals(that: Any): Boolean = that match {
    case that: exp.Exp[T] => astree.equals(that.astree)
    case _ => false
  }

  def eql(that : exp.Exp[T]): Boolean
  def isLit(value : Double):Boolean = false
  def isAdd(left : exp.Exp[T], right: exp.Exp[T]):Boolean = false
  def isSub(left : exp.Exp[T], right: exp.Exp[T]):Boolean = false
  def isMult(left : exp.Exp[T], right: exp.Exp[T]):Boolean = false
  def isNeg(inner : exp.Exp[T]):Boolean = false
  def isDivd(left : exp.Exp[T], right: exp.Exp[T]):Boolean = false
}

trait Factory[T] extends exp.m5.Factory[T] {
  implicit override def convert(toConvert: exp.Exp[T]) : exp.m6.Exp[T]
}

trait Lit[T] extends exp.m5.Lit[T] with Exp[T] {
  override def isLit(value : Double):Boolean = value == this.value
  override def eql(that : exp.Exp[T]): Boolean = that.isLit(value)
}

trait Add[T] extends exp.m5.Add[T] with Exp[T] {
  override def isAdd(left : exp.Exp[T], right: exp.Exp[T]):Boolean = left.eql(this.left) && right.eql(this.right)
  override def eql(that : exp.Exp[T]): Boolean = that.isAdd(left, right)
}

trait Sub[T] extends exp.m5.Sub[T] with Exp[T] {
  override def isSub(left : exp.Exp[T], right: exp.Exp[T]):Boolean = left.eql(this.left) && right.eql(this.right)
  override def eql(that : exp.Exp[T]): Boolean = that.isSub(left, right)
}

trait Mult[T] extends exp.m5.Mult[T] with Exp[T] {
  override def isMult(left : exp.Exp[T], right: exp.Exp[T]):Boolean = left.eql(this.left) && right.eql(this.right)
  override def eql(that : exp.Exp[T]): Boolean = that.isMult(left, right)
}

trait Divd[T] extends exp.m5.Divd[T] with Exp[T] {
  override def isDivd(left : exp.Exp[T], right: exp.Exp[T]):Boolean = left.eql(this.left) && right.eql(this.right)
  override def eql(that : exp.Exp[T]): Boolean = that.isDivd(left, right)
}

trait Neg[T] extends exp.m5.Neg[T] with Exp[T] {
  override def isNeg(inner: exp.Exp[T]):Boolean = inner.eql(this.inner)
  override def eql(that : exp.Exp[T]): Boolean = that.isNeg(inner)
}

object finalized {

  trait Exp extends exp.m6.Exp[Exp] with Factory {
    def getSelf : Exp = this
  }

  trait Factory extends exp.m6.Factory[Exp] {
    override def lit(value : Double): Exp = new Lit(value)
    override def add(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Add(left, right)
    override def sub(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Sub(left, right)
    override def mult(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Mult(left, right)
    override def neg(inner : exp.Exp[Exp]): Exp = new Neg(inner)
    override def divd(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Divd(left, right)

    implicit override def convert(toConvert : exp.Exp[Exp]) : Exp = toConvert.getSelf
  }

  /* No need to redeclare types above when Exp can be mixed in as a trait with a default method implementation */
  class Lit(val value : Double) extends exp.m6.Lit[Exp] with Exp
  class Add(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m6.Add[Exp] with Exp
  class Sub(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m6.Sub[Exp] with Exp
  class Mult(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m6.Mult[Exp] with Exp
  class Neg(var _inner : exp.Exp[Exp]) extends exp.m6.Neg[Exp] with Exp
  class Divd(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m6.Divd[Exp] with Exp
}