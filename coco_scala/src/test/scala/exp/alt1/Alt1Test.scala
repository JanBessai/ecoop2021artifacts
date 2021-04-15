    package exp.alt1

import org.scalatest.FunSuite

    trait TestTemplate[FT] extends Factory[FT] with exp.m2.TestTemplate[FT] {
      val suite:FunSuite
      import suite._

      override def test() : Unit = {
        super.test()
        assert(-3.0 ===convert(convert(this.sub(this.lit(1.0), this.lit(2.0))).multby(this.lit(3.0))).eval)

        assert(9.0 ===convert(convert(this.add(this.lit(1.0), this.lit(2.0))).multby(this.lit(3.0))).eval)
      }
    }

    class Alt1Test extends FunSuite { self =>

      object ActualTest extends TestTemplate[exp.alt1.finalized.Exp] with finalized.Factory {
        val suite: FunSuite = self
      }

      test("Alt1") {
        ActualTest.test()
      }
    }
