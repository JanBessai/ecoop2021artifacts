package exp.m0

import org.scalatest.FunSuite

trait TestTemplate[FT] extends Factory[FT] {
  val suite:FunSuite
  import suite._

  def test() : Unit = {

    val expr1 = this.add(this.lit(1.0), this.lit(2.0))
    assert(3.0 === convert(expr1).eval)

    val expr2 = this.lit(2.0)
    assert(2.0 === expr2.eval)

    assert(3.0 === this.add(this.lit(1.0), this.lit(2.0)).eval)
    assert(5.0 === this.lit(5.0).eval)
  }
}

class M0Test extends FunSuite { self =>

  object ActualTest extends TestTemplate[finalized.Exp] with finalized.Factory {
    val suite: FunSuite = self
  }

  test("M0") {
    ActualTest.test()
  }
}
