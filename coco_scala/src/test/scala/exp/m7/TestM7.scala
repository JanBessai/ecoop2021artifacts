package exp.m7

import org.scalatest.FunSuite

class TestM7 extends FunSuite with finalized.Factory {

  test("all") {
    val big = add(
      add(lit(-36),mult(sub(lit(78), lit(76)), lit(19))),
      divd(neg(lit(-6)), lit(2))
    )
    assert(big.eval == 5)

    assert(List(-36, -6, 2, 19, 76, 78).sorted == big.collect.sorted)
  }

  test("powBy") {
    val one = lit(1)
    val two = lit(2)
    val mb = add(one, two).powBy(lit(3))
    assert(mb.eval === 27)

    val sb = sub(one, two).powBy(lit(3))
    assert(sb.eval === -1)

    val a = lit(3)
    val n = lit(-1)
    assert (mb.equals(mult(mult(a,a),a)))
    assert (sb.equals(mult(mult(n,n),n)))

    // negative powers
    assert(lit(2).powBy(lit(-2)).eval == .25)
    println(lit(2).powBy(lit(-2)).prettyp)
    println(divd(lit(1), mult(lit(2),lit(2))).prettyp)
    assert(lit(2).powBy(lit(-2)).equals(divd(lit(1), mult(lit(2),lit(2)))))
  }
}
