package exp

trait Exp[T] {
  def getSelf:T
}

trait Factory[T] {
  implicit def convert(other:Exp[T]) : Exp[T]
}
