package exp.m1

import org.scalatest.FunSuite

trait TestTemplate[FT] extends Factory[FT] with exp.m0.TestTemplate[FT] {
  val suite:FunSuite
  import suite._

  override def test() : Unit = {
    super.test()
    val one = lit(3)
    val two = lit(8)
    val subOneTwo = sub(one, two)
    assert(subOneTwo.eval === -5)
  }
}

class M1Test extends FunSuite { self =>

  object ActualTest extends TestTemplate[exp.m0.finalized.Exp] with finalized.Factory {
    val suite: FunSuite = self
  }

  test("M1") {
    ActualTest.test()
  }
}
