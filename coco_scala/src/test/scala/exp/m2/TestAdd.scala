package exp.m2

import org.scalatest.FunSuite

class TestAdd extends FunSuite with finalized.Factory {

  test("Lit") {
    val one = lit(3)
    val two = lit(8)
    val addOneTwo = add(one, two)
    assert(addOneTwo.prettyp === "(3.0 + 8.0)")
  }
}
