package exp.m3

import org.scalatest.FunSuite

class TestNeg extends FunSuite with finalized.Factory {

  test("Neg") {
    val one = lit(16)
    val negOne = neg(one)
    assert(negOne.prettyp === "(- 16.0)")
  }
}
