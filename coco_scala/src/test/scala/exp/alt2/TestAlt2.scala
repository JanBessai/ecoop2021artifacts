package exp.alt2

import org.scalactic.TolerantNumerics
import org.scalatest.FunSuite

class TestAlt2 extends FunSuite with finalized.Factory {

  test("Pow") {
    val one = lit(3)
    val two = lit(2)
    val p = power(one, two)           // 3^2 = 9
    val mb = p.multBy(lit(2))

    implicit val doubleEquality = TolerantNumerics.tolerantDoubleEquality(0.0001)
    assert(mb.eval === 18.0)

    // exponent is changed (by adding logarithms) to be 3^(2 + 6309297535714574)
    assert(mb.prettyp.matches("[(]3.0 \\^ [(]2.0 \\+ 0.630929\\d*[)][)]"))
  }
}
