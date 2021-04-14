package exp.m4

import org.scalatest.FunSuite

class TestAdd extends FunSuite with finalized.Factory {

  test("None to Simplify") {
    val one = lit(3)
    val two = lit(8)
    val addOneTwo = add(one, two)
    assert(addOneTwo.simplify.prettyp === "(3.0 + 8.0)")
  }

  test("Add Simplify") {
    val one = lit(0)
    val two = lit(8)
    val addOneTwo = add(one, two)
    assert(addOneTwo.simplify.prettyp === "8.0")

    val add2 = add(two, one)
    assert(add2.simplify.prettyp === "8.0")

    val add3 = add(addOneTwo, add2)
    assert(add3.simplify.prettyp === "(8.0 + 8.0)")
  }

  test("Collect") {
    val one = lit(2)
    val two = lit(8)
    val three = lit(3)
    val all = add(one, add(two, three)).collect
    assert(all.sortWith(_ < _) == List[Double](2.0, 3.0, 8.0))
  }
}
