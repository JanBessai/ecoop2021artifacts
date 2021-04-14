package exp.m2

trait Exp[T] extends exp.m0.Exp[T] with Factory[T] {
  def prettyp : String
}

trait Factory[T] extends exp.m1.Factory[T] {
  implicit override def convert(toConvert:exp.Exp[T]) : exp.m2.Exp[T]
}

trait Lit[T] extends exp.m0.Lit[T] with Exp[T] {
  def prettyp: String = value.toString
}

trait Add[T] extends exp.m0.Add[T] with Exp[T] {
  def prettyp: String = String.format("(%s + %s)", left.prettyp, right.prettyp)
}

trait Sub[T] extends exp.m1.Sub[T] with Exp[T] {
  def prettyp: String = String.format("(%s - %s)", left.prettyp, right.prettyp)
}

object finalized {

  trait Exp extends exp.m2.Exp[Exp] with Factory {
    def getSelf : Exp = this
  }

  trait Factory extends exp.m2.Factory[Exp] {
    override def lit(value : Double): Exp = new Lit(value)

    override def add(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Add(left, right)
    override def sub(left : exp.Exp[Exp], right : exp.Exp[Exp]) : Exp = new Sub(left, right)

    implicit override def convert(toConvert : exp.Exp[Exp]) : Exp = toConvert.getSelf
  }

  class Lit(val value : Double) extends Exp with exp.m2.Lit[Exp]
  class Add(val left : exp.Exp[Exp], val right:exp.Exp[Exp]) extends exp.m2.Add[Exp] with Exp
  class Sub(val left : exp.Exp[Exp], val right:exp.Exp[Exp]) extends exp.m2.Sub[Exp] with Exp
}