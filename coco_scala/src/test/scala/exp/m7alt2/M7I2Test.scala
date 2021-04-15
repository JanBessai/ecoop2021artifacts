    package exp.m7alt2

import org.scalatest.FunSuite

    trait M7Branch[FT] extends exp.m7.TestTemplate[FT] {

    }

    trait Alt2Branch[FT] extends exp.alt2.TestTemplate[FT] {

    }

    trait TestTemplate[FT] extends Factory[FT] with M7Branch[FT] with Alt2Branch[FT] {
      val suite:FunSuite
      import suite._

      abstract override def test() : Unit = {
        super[M7Branch].test()
        super[Alt2Branch].test()

        val m = this.mult(this.lit(2.0), this.lit(5.0))
        val mb = m.multby(this.lit(4.0))

        val pwr = this.power(this.lit(2.0), this.lit(5.0))
        val pwr2 = this.lit(2.0).powby(this.lit(5.0))

        assert(!pwr.eql(mb))
        assert(!mb.eql(pwr))

        assert(pwr.equals(pwr2))
        assert(pwr.eql(pwr2))
        assert(pwr2.eql(pwr))

        val neg = this.neg(this.lit(2.0))
        val neg2 = neg.powby(this.lit(5.0))
        assert(-32.0 === neg2.eval)

        val neg3 = neg.multby(this.lit(5.0))
        assert(-10.0 === neg3.eval)

        val divd2 = this.divd(this.lit(6.0), lit(2.0)).multby(this.lit(5.0))
        assert(15.0 === divd2.eval)

        assert(40.0 === mb.eval)
        assert("((2.0*5.0)*4.0)" === mb.prettyp)

        val expr1 = this.power(this.lit(3.0), this.lit(1.0))
        assert("3.0" === expr1.simplify.prettyp)

        val expr2 = this.power(this.lit(1.0), this.lit(2.0))
        assert("1.0" === expr2.simplify.prettyp)

        val expr3 = this.power(this.lit(3.0), this.lit(2.0))
        assert("(3.0^2.0)" === expr3.simplify.prettyp)

        // 43046721 = ((9^2)^2)^2
        val h1 = this.power(this.lit(43046721.0), this.lit(0.5))
        val h2 = this.power(h1, this.lit(0.5))
        val threeDeep = this.power(h2, this.lit(0.5))

        val pwr1 = this.power(lit(5.0), threeDeep)
        pwr1.truncate(1)
        assert("(5.0^9.0)" === pwr1.prettyp)

        assert(this.power(this.lit(1.0), this.lit(12.0)).collect === Seq(1.0, 12.0))

        val pwr3 = this.power(lit(2.0), lit(3.0))
        val pwr4 = pwr3.powby(this.lit(4.0))
        assert("((2.0^3.0)^4.0)" === pwr4.prettyp)
      }
    }

    class M7Alt2Test extends FunSuite { self =>

      object ActualTest extends TestTemplate[exp.m7alt2.finalized.Exp] with finalized.Factory {
        val suite: FunSuite = self
      }

      test("M7Alt2") {
        ActualTest.test()
      }
    }
