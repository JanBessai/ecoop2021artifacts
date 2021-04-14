package exp.alt1

import org.scalatest.FunSuite

class TestAlt1 extends FunSuite with finalized.Factory {

  test("Add") {
    val one = lit(3)
    val two = lit(8)
    val addOneTwo = add(one, two)
    val mb = addOneTwo.multBy(lit(5))

    assert(mb.eval === 55.0)
    val z1 = sub(lit(0),add(lit(3),lit(3)))
    val z2 = sub(lit(0),add(lit(8),lit(8)))
    assert(addOneTwo.multBy(lit(-2)).prettyp === add(z1, z2).prettyp)
  }

  test("Sub") {
    val one = lit(3)
    val two = lit(1)
    val subone = sub(one, two)
    val sb = subone.multBy(lit(5))

    assert(sb.eval === 10.0)
  }
}
