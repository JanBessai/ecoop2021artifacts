package exp.m3

import org.scalatest.FunSuite

class TestMult extends FunSuite with finalized.Factory {

  test("Lit") {
    val one = lit(3)
    val two = lit(8)
    val multOneTwo = mult(one, two)
    assert(multOneTwo.prettyp === "(3.0 * 8.0)")
    assert(multOneTwo.eval === 24)
  }
}
