package scans.m4

import scans.api    // access lzw function placed in API

trait Circuit[T] extends scans.m3.Circuit[T] with Factory[T] {
  def layout(f: Int => Int) : List[List[(Int, Int)]]
}

trait Factory[T] extends scans.m3.Factory[T] {
  implicit override def convert(toConvert:scans.Circuit[T]) : scans.m4.Circuit[T]
}

trait Identity[T] extends scans.m3.Identity[T]  with Circuit[T] {
  def layout(f: Int => Int) = List()
}

trait Fan[T] extends scans.m3.Fan[T]  with Circuit[T] {
  def layout(f: Int => Int) =
    List(for (i <- List.range(1, n)) yield (f(0), f(i)))
}

trait Above[T] extends scans.m3.Above[T] with Circuit[T] {
  def c1: scans.Circuit[T]
  def c2: scans.Circuit[T]

  def layout(f: Int => Int) = c1.layout(f) ++ c2.layout(f)
}

trait Beside[T] extends scans.m3.Beside[T]  with Circuit[T] {
  def c1: scans.Circuit[T]
  def c2: scans.Circuit[T]

  def layout(f: Int => Int) =
    api.lzw (c1 layout f,c2.layout(f compose (c1.width + _))) (_ ++ _)
}

trait Stretch[T] extends scans.m3.Stretch[T]  with Circuit[T] {
  def c: scans.Circuit[T]

  def layout(f: Int => Int) = {
    val vs = ns.scanLeft(0)(_ + _).tail
    c.layout(f.compose(vs(_) - 1))
  }
}

object finalized {

  trait Circuit extends scans.m4.Circuit[Circuit] with Factory {
    def getSelf : Circuit = this
  }

  trait Factory extends scans.m4.Factory[Circuit]  {
    override def identity(n: Int) : Circuit = new Identity(n)
    override def fan(n: Int) : Circuit = new Fan(n)
    override def above(c1: scans.Circuit[Circuit], c2: scans.Circuit[Circuit]) : Circuit = new Above(c1, c2)
    override def beside(c1: scans.Circuit[Circuit], c2: scans.Circuit[Circuit]) : Circuit = new Beside(c1, c2)
    override def stretch(c:scans.Circuit[Circuit], xs:Int*) : Circuit = new Stretch(c, xs.toList)

    override implicit def convert(toConvert: scans.Circuit[Circuit]): Circuit = toConvert.getSelf
  }

  class Identity(val n:Int) extends Circuit with scans.m4.Identity[Circuit]
  class Fan(val n:Int) extends Circuit with scans.m4.Fan[Circuit]
  class Above(val c1:scans.Circuit[Circuit], val c2:scans.Circuit[Circuit]) extends scans.m4.Above[Circuit] with Circuit
  class Beside(val c1:scans.Circuit[Circuit], val c2:scans.Circuit[Circuit]) extends scans.m4.Beside[Circuit] with Circuit
  class Stretch(val c:scans.Circuit[Circuit], val ns:List[Int]) extends scans.m4.Stretch [Circuit] with Circuit
}