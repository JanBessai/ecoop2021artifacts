    package exp.m3

  import org.scalatest.FunSuite

    trait TestTemplate[FT] extends Factory[FT] with exp.m2.TestTemplate[FT] {
      val suite:FunSuite
      import suite._

      override def test() : Unit = {
        super.test()

        val expr1 = this.mult(this.lit(3.0), this.lit(2.0));
        assert("(3.0*2.0)" === convert(expr1).prettyp)

        val expr2 = this.divd(this.lit(3.0), this.lit(2.0));
       assert("(3.0/2.0)" === convert(expr2).prettyp)

        val expr3 = this.neg(this.lit(3.0));
       assert("(-3.0)"===  convert(expr3).prettyp)

        val expr4 = this.neg(expr1);
       assert("(-(3.0*2.0))"===  convert(expr4).prettyp)

        assert(convert(this.neg(this.lit(1.0))).eval === -1.0, 0.0);
        assert("(-1.0)"  === convert(this.neg(this.lit(1.0))).prettyp)
        assert("((5.0/2.0)*4.0)" === convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).prettyp)
        assert(10.0 === convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).eval)
        assert(convert(this.neg(this.lit(5.0))).eval === -5.0)
        assert("(-(2.0*3.0))" === convert(this.neg(this.mult(this.lit(2.0), this.lit(3.0)))).prettyp)
      }
    }

    class M3Test extends FunSuite { self =>

      object ActualTest extends TestTemplate[exp.m2.finalized.Exp] with finalized.Factory {
        val suite: FunSuite = self
      }

      test("M3") {
        ActualTest.test()
      }
    }
