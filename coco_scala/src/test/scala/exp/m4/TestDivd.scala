package exp.m4

import org.scalatest.FunSuite

class TestDivd extends FunSuite with finalized.Factory {

  test("Lit") {
    val one = lit(16)
    val two = lit(8)
    val divdOneTwo = divd(one, two)
    assert(divdOneTwo.prettyp === "(16.0 / 8.0)")
    assert(divdOneTwo.eval === 2)
  }

  test("DivD Simplify") {
    val one = lit(8)
    val none = lit(-8)
    val two = lit(1)
    val addOneTwo = divd(one, two)
    assert(addOneTwo.simplify.prettyp === "8.0")

    assert(divd(lit(0), one).simplify.prettyp == "0.0")

    assert(divd(one, one).simplify.prettyp == "1.0")
    assert(divd(one, none).simplify.prettyp == "-1.0")

  }
}
