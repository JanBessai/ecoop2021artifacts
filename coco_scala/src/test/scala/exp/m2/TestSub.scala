package exp.m2

import org.scalatest.FunSuite

class TestSub extends FunSuite with finalized.Factory {

  test("Lit") {
    val one = lit(3)
    val two = lit(8)
    val subOneTwo = sub(one, two)
    assert(subOneTwo.prettyp === "(3.0 - 8.0)")

    val subOneOneTwo = new finalized.Sub(one, subOneTwo)
    assert(subOneOneTwo.prettyp === "(3.0 - (3.0 - 8.0))")
  }
}
