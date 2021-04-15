package exp.m1

import org.scalatest.FunSuite

trait TestTemplate[FT] extends Factory[FT] with exp.m0.TestTemplate[FT] {
  val suite:FunSuite
  import suite._

  override def test() : Unit = {
    super.test()

    val expr1 = this.sub(this.lit(1.0), this.lit(2.0))
    assert(-1.0 === expr1.eval)

    val expr2 = this.lit(2.0)
    assert(2.0 === expr2.eval)
    assert(this.sub(this.lit(1.0), this.lit(2.0)).eval === -1.0)
  }
}

class M1Test extends FunSuite { self =>

  object ActualTest extends TestTemplate[exp.m0.finalized.Exp] with finalized.Factory {
    val suite: FunSuite = self
  }

  test("M1") {
    ActualTest.test()
  }
}
