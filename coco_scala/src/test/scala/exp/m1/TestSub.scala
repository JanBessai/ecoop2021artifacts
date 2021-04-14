package exp.m1

import org.scalatest.FunSuite

class TestSub extends FunSuite with finalized.Factory {

  test("Lit") {
    val one = lit(3)
    val two = lit(8)
    val subOneTwo = sub(one, two)
    assert(subOneTwo.eval === -5)
  }
}
