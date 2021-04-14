package exp.m4

import org.scalatest.FunSuite

class TestMult extends FunSuite with finalized.Factory {

  test("Lit") {
    val one = lit(3)
    val two = lit(8)
    val multOneTwo = mult(one, two)
    assert(multOneTwo.prettyp === "(3.0 * 8.0)")
    assert(multOneTwo.eval === 24)
  }

  test("Mult Simplify") {
    val one = lit(8)
    val two = lit(1)
    val m = mult(one, two)
    assert(m.simplify.prettyp === "8.0")
    assert(mult(two, one).simplify.prettyp === "8.0")

    assert(mult(one, lit(0)).simplify.prettyp === "0.0")
    assert(mult(lit(0), one).simplify.prettyp === "0.0")
  }
}
