package exp.m5

trait Exp[T] extends exp.m4.Exp[T] with Factory[T] {
  def astree : Tree
  def id : Int
}

trait Factory[T] extends exp.m4.Factory[T] {
  implicit override def convert(toConvert: exp.Exp[T]) : exp.m5.Exp[T]
}

trait Lit[T] extends exp.m4.Lit[T] with Exp[T] {
  def astree : Tree = new Node(id, new Leaf(value))
  def id : Int = 76407
}

trait BinaryExp[T] extends exp.m4.BinaryExp[T] with Exp[T] {
  def astree : Tree = new Node(id, left.astree, right.astree)
}

trait Add[T] extends exp.m4.Add[T] with BinaryExp[T] {
  def id : Int = 65665
}

trait Sub[T] extends exp.m4.Sub[T] with BinaryExp[T] {
  def id: Int = 83488
}

trait Mult[T] extends exp.m4.Mult[T] with BinaryExp[T] {
  def id : Int = 2409808
}

trait Divd[T] extends exp.m4.Divd[T] with BinaryExp[T] {
  def id: Int = 2130451
}

trait Neg[T] extends exp.m4.Neg[T] with Exp[T] {
  def astree: Tree = new Node(id, inner.astree)
  def id: Int = 78192
}

object finalized {

  trait Exp extends exp.m5.Exp[Exp] with Factory {
    def getSelf : Exp = this
  }

  trait BinaryExp extends Exp with exp.m5.BinaryExp[Exp] { }

  trait Factory extends exp.m4.Factory[Exp] {
    override def lit(value : Double): Exp = new Lit(value)
    override def add(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Add(left, right)
    override def sub(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Sub(left, right)
    override def mult(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Mult(left, right)
    override def neg(inner : exp.Exp[Exp]): Exp = new Neg(inner)
    override def divd(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Divd(left, right)

    implicit override def convert(toConvert : exp.Exp[Exp]) : Exp = toConvert.getSelf
  }

  class Lit(val value : Double) extends Exp with exp.m5.Lit[Exp]
  class Add(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m5.Add[Exp] with BinaryExp
  class Sub(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m5.Sub[Exp] with BinaryExp
  class Mult(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m5.Mult[Exp] with BinaryExp
  class Neg(var _inner : exp.Exp[Exp]) extends exp.m5.Neg[Exp] with Exp
  class Divd(var _left : exp.Exp[Exp], var _right : exp.Exp[Exp]) extends exp.m5.Divd[Exp] with BinaryExp
}