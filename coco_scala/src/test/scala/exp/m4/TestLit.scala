package exp.m4

import org.scalatest.FunSuite

class TestLit extends FunSuite with finalized.Factory {

  test("Lit") {
    assert(lit(3).simplify.prettyp === "3.0")
    assert(lit(3).collect === List[Double](3.0))
  }
}
