package scans

trait Circuit[T] extends Factory[T] {
  def getSelf:T
}

trait Factory[T] {
  implicit def convert(other:Circuit[T]) : Circuit[T]
}

object api {
  // helper function placed here for easy access
  def lzw[A](xs: List[A], ys: List[A])(f: (A, A) => A): List[A] = (xs, ys) match {
    case (Nil,_)        =>  ys
    case (_,Nil)        =>  xs
    case (x::xs,y::ys)  =>  f(x,y) :: lzw (xs,ys) (f)
  }
}