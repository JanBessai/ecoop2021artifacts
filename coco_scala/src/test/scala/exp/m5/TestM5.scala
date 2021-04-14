package exp.m5

import org.scalatest.FunSuite

class TestM5 extends FunSuite with finalized.Factory {

  test("all") {
    val big = add(
      add(lit(-36),mult(sub(lit(78), lit(76)), lit(19))),
      divd(neg(lit(-6)), lit(2))
    )
    assert(big.eval == 5)

    assert(List(-36, -6, 2, 19, 76, 78).sorted == big.collect.sorted)
  }

  test("Mult") {
    val one = lit(3)
    val two = lit(8)
    val multOneTwo = mult(one, two)
    val expected = new Node(Seq(new Leaf(3.0), new Leaf(8.0)), 2409808)

    assert(multOneTwo.astree === expected)
  }
}
