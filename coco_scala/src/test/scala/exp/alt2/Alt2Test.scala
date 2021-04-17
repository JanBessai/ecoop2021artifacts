package exp.alt2

import org.scalatest.FunSuite

trait TestTemplate[FT] extends Factory[FT] with exp.alt1.TestTemplate[FT] {
  val suite:FunSuite
  import suite._

  override def test() : Unit = {
    super.test()

    val pwr = this.power(this.lit(2.0), this.lit(5.0))
    val mb = pwr.multby(this.lit(4.0)) //mult by 4 just like raising by additional 2

    assert(32.0 === pwr.eval)
    assert("(2.0^5.0)" === pwr.prettyp)

    //based upon the CONTEXT (M7I2 or I2) you might get different results for mb
    assert("(2.0^(5.0+2.0))" === mb.prettyp || "((2.0^5.0)*4.0)".equals(mb.prettyp))
  }
}

class Alt2Test extends FunSuite { self =>
  object ActualTest extends TestTemplate[exp.alt1.finalized.Exp] with finalized.Factory {
    val suite: FunSuite = self
  }

  test("Alt2") {
    ActualTest.test()
  }
}
