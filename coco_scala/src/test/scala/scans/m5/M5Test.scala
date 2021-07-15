package scans.m5

import org.scalatest.FunSuite
import scans.m1.api

trait TestTemplate[FT] extends Factory[FT] with scans.m1.TestTemplate[FT] {
  val suite:FunSuite
  import suite._

  override def test() : Unit = {
    super.test()

    val circ1 = convert(this.rstretch(api.brentKung(this), 6, 12))
    assert(circ1.width == 18)
  }
}

class M5Test extends FunSuite { self =>

  object ActualTest extends TestTemplate[scans.m4.finalized.Circuit] with finalized.Factory {
    val suite: FunSuite = self
  }

  test("M5") {
    ActualTest.test()
  }
}
