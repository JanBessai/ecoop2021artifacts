package exp.m7alt2

import org.scalatest.FunSuite

class TestM7Alt2 extends FunSuite with finalized.Factory {

  test("all") {
    val big = power(
      add(lit(-36),mult(sub(lit(78), lit(76)), lit(19))),
      divd(neg(lit(-6)), lit(2))
    )
    assert(big.eval == 8)

    assert(List(-36, -6, 2, 19, 76, 78).sorted == big.collect.sorted)
  }

  test("replace") {
    val one = lit(3)
    val two = lit(8)
    val addOne = add(one, two)
    val mb = addOne.multBy(lit(5))

    assert(mb.eval === 55)

    val pw = two.powBy(one)
    val pw2 = power(two, one)
    assert(pw.equals(pw2))
  }

  test ("simplify") {
    // base case with nothing
    assert(power(lit(2), lit(3)).simplify.equals(power(lit(2), lit(3))))

    // raising one to any power results in just 1
    assert(power(lit(1), lit(18)).simplify.equals(lit(1)))

    // anything raised to 0 is 1
    assert(power(mult(lit(3), lit(7)), lit(0)).simplify.equals(lit(1)))

    // 0 raised to anything is 0
    assert(power(lit(0), mult(lit(3), lit(7))).simplify.equals(lit(0)))

    // internals are simplified
    val complicated = mult(add(lit(2),mult(lit(3),lit(5))), lit(7))
    assert(add(lit(1), lit(1)).equals(
           add(power(complicated, lit(0)), power(lit(1), complicated)).simplify))

    // raising a complicated base to 1 results in base
    assert(power(complicated, lit(1)).simplify.equals(complicated))

    // sanity check
    assert(power(complicated,lit(2)).eql(power(complicated,lit(2))))
    assert(!power(complicated,lit(2)).eql(complicated))

    // raising to power 1 can be simplified
    assert(power(complicated,lit(1)).simplify.eql(complicated.simplify))
  }
}
