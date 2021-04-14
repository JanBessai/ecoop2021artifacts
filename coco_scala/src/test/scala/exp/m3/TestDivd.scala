package exp.m3

import org.scalatest.FunSuite

class TestDivd extends FunSuite with finalized.Factory {

  test("Lit") {
    val one = lit(16)
    val two = lit(8)
    val divdOneTwo = divd(one, two)
    assert(divdOneTwo.prettyp === "(16.0 / 8.0)")
    assert(divdOneTwo.eval === 2)
  }
}
