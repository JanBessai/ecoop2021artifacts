    package exp.m7

import org.scalatest.FunSuite

    trait TestTemplate[FT] extends Factory[FT] with exp.m4.TestTemplate[FT] {
      val suite:FunSuite
      import suite._

      override def test() : Unit = {
        super.test()

        val pby = convert(this.lit(3.0)).powby(this.lit(2.0));
        val d1 = convert(this.divd(this.lit(5.0), this.lit(2.0))).powby(this.lit(2.0));
        val m1 = convert(this.mult(this.lit(5.0), this.lit(2.0))).powby(this.lit(2.0));
        val a1 = convert(this.add(this.lit(5.0), this.lit(2.0))).powby(this.lit(2.0));
        val s1 = convert(this.sub(this.lit(5.0), this.lit(3.0))).powby(this.lit(2.0));
        val n1 = convert(this.neg(this.lit(5.0))).powby(this.lit(2.0));

       assert(9.0 === convert(pby).eval)
       assert(6.25 === convert(d1).eval)
       assert(100.0 === convert(m1).eval)
       assert(49.0 === convert(a1).eval)
       assert(4.0 === convert(s1).eval)
       assert(25.0 === convert(n1).eval)

       assert(28561.0 === convert(convert(this.add(this.lit(1.0), this.lit(12.0))).powby(this.lit(4.0))).eval)
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
