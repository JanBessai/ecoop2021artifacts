package scans.m2

trait Circuit[T] extends scans.m1.Circuit[T] with Factory[T] {
  def depth: Int
}

trait Factory[T] extends scans.m1.Factory[T] {
  implicit override def convert(toConvert:scans.Circuit[T]) : scans.m2.Circuit[T]
}

trait Identity[T] extends scans.m1.Identity[T] with Circuit[T] {
  def depth: Int = 0
}

trait Fan[T] extends scans.m1.Fan[T] with Circuit[T] {
  def depth: Int = 1
}

trait Above[T] extends scans.m1.Above[T] with Circuit[T] {
  def c1: scans.Circuit[T]
  def c2: scans.Circuit[T]

  def depth: Int = c1.depth + c2.depth
}

trait Beside[T] extends scans.m1.Beside[T] with Circuit[T] {
  def c1: scans.Circuit[T]
  def c2: scans.Circuit[T]

  def depth: Int = Math.max(c1.depth, c2.depth)
}

trait Stretch[T] extends scans.m1.Stretch[T] with Circuit[T] {
  def c: scans.Circuit[T]
  def depth: Int = c.depth
}

object finalized {

  trait Circuit extends scans.m2.Circuit[Circuit] with Factory {
    def getSelf : Circuit = this
  }

  trait Factory extends scans.m2.Factory[Circuit]  {
    override def identity(n: Int) : Circuit = new Identity(n)
    override def fan(n: Int) : Circuit = new Fan(n)
    override def above(c1: scans.Circuit[Circuit], c2: scans.Circuit[Circuit]) : Circuit = new Above(c1, c2)
    override def beside(c1: scans.Circuit[Circuit], c2: scans.Circuit[Circuit]) : Circuit = new Beside(c1, c2)
    override def stretch(c:scans.Circuit[Circuit], xs:Int*) : Circuit = new Stretch(c, xs.toList)

    override implicit def convert(toConvert: scans.Circuit[Circuit]): Circuit = toConvert.getSelf
  }

  class Identity(val n:Int) extends Circuit with scans.m2.Identity[Circuit]
  class Fan(val n:Int) extends Circuit with scans.m2.Fan[Circuit]
  class Above(val c1:scans.Circuit[Circuit], val c2:scans.Circuit[Circuit]) extends scans.m2.Above[Circuit] with Circuit
  class Beside(val c1:scans.Circuit[Circuit], val c2:scans.Circuit[Circuit]) extends scans.m2.Beside[Circuit] with Circuit
  class Stretch(val c:scans.Circuit[Circuit], val ns:List[Int]) extends scans.m2.Stretch [Circuit] with Circuit
}