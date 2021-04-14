package exp.m4

import org.scalatest.FunSuite

class TestNeg extends FunSuite with finalized.Factory {

  test("Neg") {
    assert(neg(lit(3)).simplify.prettyp === "(- 3.0)")
    assert(neg(lit(0)).simplify.prettyp === "0.0")
    assert(lit(3).collect === List[Double](3.0))
  }
}
