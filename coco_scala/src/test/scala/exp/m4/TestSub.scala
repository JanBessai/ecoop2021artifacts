package exp.m4

import org.scalatest.FunSuite

class TestSub extends FunSuite with finalized.Factory {

  test("Lit") {
    val one = lit(3)
    val two = lit(8)
    val subOneTwo = sub(one, two)
    assert(subOneTwo.prettyp === "(3.0 - 8.0)")

    val sub2 = new finalized.Sub(one, subOneTwo)
    assert(sub2.prettyp === "(3.0 - (3.0 - 8.0))")
  }

  test("Sub Simplify") {
    val one = lit(8)
    val two = lit(0)
    val addOneTwo = sub(one, two)
    assert(addOneTwo.simplify.prettyp === "8.0")

    assert(sub(two,one).simplify.prettyp === "(- 8.0)")

    // nothing special
    assert(sub(lit(17), lit(14)).simplify.prettyp === "(17.0 - 14.0)")

    // zero
    assert(sub(one, one).simplify.prettyp === "0.0")
  }
}
