package exp.m0

trait Exp[T] extends exp.Exp[T] with Factory[T] {
  def eval: Double
}

trait Factory[T] extends exp.Factory[T] {
  def lit(value:Double) : exp.Exp[T]
  def add(left:exp.Exp[T], right:exp.Exp[T]) : exp.Exp[T]

  implicit override def convert(toConvert:exp.Exp[T]) : Exp[T]
}

trait Lit[T] extends Exp[T] {
  def value: Double

  def eval: Double = value
}

trait Add[T] extends Exp[T] {
  def left : exp.Exp[T]
  def right : exp.Exp[T]

  def eval: Double = left.eval + right.eval
}

object finalized {
  trait Exp extends exp.m0.Exp[Exp] with Factory {
    def getSelf : Exp = this
  }

  trait Factory extends exp.m0.Factory[Exp] {
    override def lit(value: Double) : Exp = new Lit(value)
    override def add(left: exp.Exp[Exp], right: exp.Exp[Exp]) : Exp = new Add(left, right)

    override implicit def convert(toConvert: exp.Exp[Exp]): Exp = toConvert.getSelf
  }

  class Lit(val value:Double) extends Exp with exp.m0.Lit[Exp]
  class Add(val left:exp.Exp[Exp], val right:exp.Exp[Exp]) extends Exp with exp.m0.Add[Exp]
}