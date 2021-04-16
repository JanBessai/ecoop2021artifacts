package exp

trait Exp[T] extends Factory[T] {
  def getSelf:T
}

trait Factory[T] {
  implicit def convert(other:Exp[T]) : Exp[T]
}
