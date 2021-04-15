package exp.m7

import org.scalatest.FunSuite

trait TestTemplate[FT] extends Factory[FT] with exp.m4.TestTemplate[FT] {
  val suite:FunSuite
  import suite._

  override def test() : Unit = {
    super.test()

    val pby = this.lit(3.0).powby(this.lit(2.0));
    val d1 = this.divd(this.lit(5.0), this.lit(2.0)).powby(this.lit(2.0));
    val m1 = this.mult(this.lit(5.0), this.lit(2.0)).powby(this.lit(2.0));
    val a1 = this.add(this.lit(5.0), this.lit(2.0)).powby(this.lit(2.0));
    val s1 = this.sub(this.lit(5.0), this.lit(3.0)).powby(this.lit(2.0));
    val n1 = this.neg(this.lit(5.0)).powby(this.lit(2.0));

    assert(9.0 === pby.eval)
    assert(6.25 === d1.eval)
    assert(100.0 === m1.eval)
    assert(49.0 === a1.eval)
    assert(4.0 === s1.eval)
    assert(25.0 === n1.eval)

    assert(28561.0 === this.add(this.lit(1.0), this.lit(12.0)).powby(this.lit(4.0)).eval)
  }
}

class M7Test extends FunSuite { self =>

  object ActualTest extends TestTemplate[exp.m7.finalized.Exp] with finalized.Factory {
    val suite: FunSuite = self
  }

  test("M7") {
    ActualTest.test()
  }
}
