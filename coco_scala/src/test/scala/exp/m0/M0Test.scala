package exp.m0

import org.scalatest.FunSuite

trait TestTemplate[FT] extends Factory[FT] {
  val suite:FunSuite
  import suite._

  def test() : Unit = {
    val one = lit(3)
    val two = lit(8)
    val addOneTwo = add(one, two)
    assert(addOneTwo.eval === 11)
  }
}

class M0Test extends FunSuite { self =>

  object ActualTest extends TestTemplate[finalized.Exp] with finalized.Factory {
    val suite: FunSuite = self
  }

  test("M0") {
    ActualTest.test()
  }
}
