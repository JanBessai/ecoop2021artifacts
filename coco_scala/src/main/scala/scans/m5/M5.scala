package scans.m5

trait Factory[T] extends scans.m4.Factory[T] {
  def rstretch(c: scans.Circuit[T], xs:Int*) : scans.Circuit[T]

  /** Covariant Conversion */
  implicit override def convert(toConvert: scans.Circuit[T]) : scans.m4.Circuit[T]
}

trait RStretch[T] extends scans.m4.Stretch[T] with Factory[T] {
  override def layout(f: Int => Int) = {
    val vs = ns.scanLeft(ns.last - 1)(_ + _).init
    c.layout(f.compose(vs(_)))
  }
}

object finalized {

  import scans.m4.finalized.Circuit

  trait Factory extends scans.m5.Factory[scans.m4.finalized.Circuit] with scans.m4.finalized.Factory {
    override def rstretch(c:scans.Circuit[Circuit], xs:Int*) : Circuit = new RStretch(c, xs.toList)
  }

  class RStretch(val c:scans.Circuit[Circuit], val ns:List[Int]) extends scans.m5.RStretch [Circuit] with Circuit with Factory
}
