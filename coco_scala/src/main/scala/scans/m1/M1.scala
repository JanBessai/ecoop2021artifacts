package scans.m1

trait Circuit[T] extends scans.Circuit[T] with Factory[T] {
  def width: Int
}

trait Factory[T] extends scans.Factory[T] {
  def identity(n:Int) : scans.Circuit[T]
  def fan(n:Int) : scans.Circuit[T]
  def above(c1:scans.Circuit[T], c2:scans.Circuit[T]) : scans.Circuit[T]
  def beside(c1:scans.Circuit[T], c2:scans.Circuit[T]) : scans.Circuit[T]
  def stretch(c:scans.Circuit[T], xs:Int*) : scans.Circuit[T]

  implicit override def convert(toConvert:scans.Circuit[T]) : scans.m1.Circuit[T]
}

object api {
  def brentKung[T](f: Factory[T]): scans.Circuit[T] =
    f.above(f.beside(f.fan(2), f.fan(2)),
      f.above(f.stretch(f.fan(2), 2, 2),
        f.beside(f.beside(f.identity(1), f.fan(2)), f.identity(1))))
}

trait Identity[T] extends Circuit[T] {
  val n:Int

  def width: Int = n
}

trait Fan[T] extends Circuit[T] {
  val n:Int

  def width: Int = n
}

trait Above[T] extends Circuit[T] {
  def c1: scans.Circuit[T]
  def c2: scans.Circuit[T]

  def width: Int = c1.width
}

trait Beside[T] extends Circuit[T] {
  def c1: scans.Circuit[T]
  def c2: scans.Circuit[T]

  def width: Int = c1.width + c2.width
}

trait Stretch[T] extends Circuit[T] {
  def c: scans.Circuit[T]
  def ns: List[Int]

  def width: Int = ns.sum
}

object finalized {
  trait Circuit extends scans.m1.Circuit[Circuit] with Factory {
    def getSelf : Circuit = this
  }

  trait Factory extends scans.m1.Factory[Circuit] {
    override def identity(n: Int) : Circuit = new Identity(n)
    override def fan(n: Int) : Circuit = new Fan(n)
    override def above(c1: scans.Circuit[Circuit], c2: scans.Circuit[Circuit]) : Circuit = new Above(c1, c2)
    override def beside(c1: scans.Circuit[Circuit], c2: scans.Circuit[Circuit]) : Circuit = new Beside(c1, c2)
    override def stretch(c:scans.Circuit[Circuit], xs:Int*) : Circuit = new Stretch(c, xs.toList)

    override implicit def convert(toConvert: scans.Circuit[Circuit]): Circuit = toConvert.getSelf
  }

  class Identity(val n:Int) extends Circuit with scans.m1.Identity[Circuit]
  class Fan(val n:Int) extends Circuit with scans.m1.Fan[Circuit]
  class Above(val c1:scans.Circuit[Circuit], val c2:scans.Circuit[Circuit]) extends Circuit with scans.m1.Above[Circuit]
  class Beside(val c1:scans.Circuit[Circuit], val c2:scans.Circuit[Circuit]) extends Circuit with scans.m1.Beside[Circuit]
  class Stretch(val c:scans.Circuit[Circuit], val ns:List[Int]) extends Circuit with scans.m1.Stretch [Circuit]
}
