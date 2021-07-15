package scans.m1

import org.scalatest.FunSuite

trait TestTemplate[FT] extends Factory[FT] {
  val suite:FunSuite
  import suite._

  def test() : Unit = {

    val circ1 = convert(this.identity(1))
    val circ2 = convert(this.identity(1))
    val circ3 = convert(this.identity(3))
    assert(circ1.width == circ2.width)
    assert(circ1.width != circ3.width)

    val circ4 = convert(api.brentKung(this))
    assert(circ4.width == 4)
  }
}

class M0Test extends FunSuite { self =>

  object ActualTest extends TestTemplate[finalized.Circuit] with finalized.Factory {
    val suite: FunSuite = self
  }

  test("M0") {
    ActualTest.test()
  }
}
