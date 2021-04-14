package exp.m2

import org.scalatest.FunSuite

class TestLit extends FunSuite with finalized.Factory {

  test("Lit") {
    assert(lit(3).eval === 3)
  }
}
