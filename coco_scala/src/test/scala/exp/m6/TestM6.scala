package exp.m6

import org.scalatest.FunSuite

class TestM6 extends FunSuite with finalized.Factory {

  test("all") {
    val big = add(
      add(lit(-36),mult(sub(lit(78), lit(76)), lit(19))),
      divd(neg(lit(-6)), lit(2))
    )
    assert(big.eval == 5)

    assert(List(-36, -6, 2, 19, 76, 78).sorted == big.collect.sorted)
  }

  test("Add") {
    val one = lit(3)
    val two = lit(8)
    val addOneTwo = add(one, two)

    val one2 = lit(3)
    val two2 = lit(8)
    val add2 = add(one2, two2)

    val one3 = lit(3)
    val two3 = lit(8)
    val add3 = add(two3, one3)

    assert(addOneTwo.equals(add2))
    assert(!addOneTwo.equals(add3))

    assert(addOneTwo.eql(add2))
    assert(!addOneTwo.eql(add3))
  }
}
