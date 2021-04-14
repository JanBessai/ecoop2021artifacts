package exp.m4

trait Exp[T] extends exp.m2.Exp[T] with Factory[T] {
  def simplify : exp.Exp[T]
  def truncate(level:Int) : Unit
  def collect : List[Double]
}

trait Factory[T] extends exp.m3.Factory[T] {
  implicit override def convert(toConvert:exp.Exp[T]) : exp.m4.Exp[T]
}

trait Lit[T] extends exp.m2.Lit[T] with Exp[T] {
  def simplify : exp.Exp[T] = this
  def truncate(level:Int) = ()
  def collect : List[Double] = List(this.value)
}

trait BinaryExp[T] extends Exp[T] {
  var _left:exp.Exp[T]
  var _right:exp.Exp[T]
  def left = _left
  def right = _right

  def truncate(level:Int) = {
    if (level > 0) {
      left.truncate(level-1)
      right.truncate(level-1)
    } else {
      _left = lit(left.eval)
      _right = lit(right.eval)
    }
  }
}

trait Add[T] extends exp.m2.Add[T] with BinaryExp[T] {
  def simplify : exp.Exp[T] = {
    if (left.eval + right.eval == 0) {
      this.lit(0)
    } else if (left.eval == 0) {
      right.simplify
    } else if (right.eval == 0) {
      left.simplify
    } else {
      this.add(left.simplify, right.simplify)
    }
  }

  def collect : List[Double] = left.collect ++ right.collect
}

trait Sub[T] extends exp.m2.Sub[T] with BinaryExp[T] {
  def simplify : exp.Exp[T] = {
    if (left.eval - right.eval == 0) {
      this.lit(0)
    } else if (right.eval == 0) {
      left.simplify
    } else if (left.eval == 0) {
      this.neg(right.simplify)     // can use neg from earlier
    } else {
      this.sub(left.simplify, right.simplify)
    }
  }

  def collect : List[Double] = left.collect ++ right.collect
}

trait Mult[T] extends exp.m3.Mult[T] with BinaryExp[T] {
  def simplify : exp.Exp[T] = {
    if (left.eval == 0 || right.eval == 0) {
      this.lit(0)
    } else if (right.eval == 1) {
      left.simplify
    } else if (left.eval == 1) {
      right.simplify     // can use neg from earlier
    } else {
      this.mult(left.simplify, right.simplify)
    }
  }

  def collect : List[Double] = left.collect ++ right.collect
}

trait Neg[T] extends exp.m3.Neg[T] with Exp[T] {
  var _inner:exp.Exp[T]
  def inner:exp.Exp[T] = _inner

  def truncate(level:Int) = {
    if (level > 0) {
      inner.truncate(level-1)
    } else {
      _inner = lit(inner.eval)
    }
  }

  def simplify : exp.Exp[T] = {
    if (inner.eval == 0 ) {
      this.lit(0)
    } else {
      this.neg(inner.simplify)
    }
  }

  def collect : List[Double] = inner.collect
}

trait Divd[T] extends exp.m3.Divd[T] with BinaryExp[T] {
  def simplify : exp.Exp[T] = {
    if (left.eval == 0 ) {
      this.lit(0)
    } else if (right.eval == 1) {
      left.simplify
    } else if (left.eval == right.eval) {
      this.lit(1)
    } else if (left.eval == -right.eval) {
      this.lit(-1)
    } else {
      this.divd(left.simplify, right.simplify)
    }
  }

  def collect : List[Double] = left.collect ++ right.collect
}

object finalized {
  trait Exp extends exp.m4.Exp[Exp] with Factory {
    def getSelf : Exp = this
  }

  trait BinaryExp extends Exp with exp.m4.BinaryExp[Exp] { }

  trait Factory extends exp.m3.Factory[Exp] {
    override def lit(value: Double) : Exp = new Lit(value)
    override def add(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Add(left, right)
    override def sub(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Sub(left, right)
    override def mult(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Mult(left, right)
    override def neg(inner : exp.Exp[Exp]) : Exp = new Neg(inner)
    override def divd(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Divd(left, right)

    implicit override def convert(toConvert : exp.Exp[Exp]) : Exp = toConvert.getSelf
  }

  class Lit(val value : Double) extends Exp with exp.m4.Lit[Exp]
  class Add(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m4.Add[Exp] with BinaryExp
  class Sub(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m4.Sub[Exp] with BinaryExp
  class Mult(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m4.Mult[Exp] with BinaryExp
  class Neg(var _inner : exp.Exp[Exp]) extends exp.m4.Neg[Exp] with Exp
  class Divd(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m4.Divd[Exp] with BinaryExp
}
