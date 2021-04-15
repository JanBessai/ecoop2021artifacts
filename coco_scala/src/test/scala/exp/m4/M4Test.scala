    package exp.m4

import org.scalatest.FunSuite

    trait TestTemplate[FT] extends Factory[FT] with exp.m3.TestTemplate[FT] {
      val suite:FunSuite
      import suite._

      override def test() : Unit = {
        super.test()


        val expr1 = this.divd(this.lit(3.0), this.lit(1.0));
        assert( "3.0" === convert(convert(expr1).simplify).prettyp);

        val expr2 = this.divd(this.lit(0.0), this.lit(2.0));
        assert( "0.0" === convert(convert(expr2).simplify).prettyp);

        val expr3 = this.divd(this.lit(3.0), this.divd(this.lit(6.0), this.lit(2.0)));
        assert( "1.0" === convert(convert(expr3).simplify).prettyp);

        val expr4 = this.neg(expr1);
        assert( "(-3.0)" === convert(convert(expr4).simplify).prettyp);

        val expr6 = this.add(this.lit(-2.0), this.lit(2.0));
        assert( "0.0" === convert(convert(expr6).simplify).prettyp);

        val expr7 = this.add(this.lit(-2.0), this.lit(0.0));
        assert( "-2.0" === convert(convert(expr7).simplify).prettyp);

        val expr8 = this.add(this.lit(-2.0), this.lit(-5.0));
        assert( "(-2.0+-5.0)" === convert(convert(expr8).simplify).prettyp);

        val sub2 = this.sub(this.lit(3.0), this.lit(3.0));
        assert( "0.0" === convert(convert(sub2).simplify).prettyp);

        val neg2 = this.neg(this.lit(0.0));
        assert( "0.0" === convert(convert(neg2).simplify).prettyp);

        val left = this.mult(this.lit(3.0), this.lit(1.0));
        val right = this.mult(this.lit(1.0), this.lit(9.0));
        val expr5 = this.divd(left, right);
        assert( "(3.0/9.0)" === convert(convert(expr5).simplify).prettyp);

        assert(convert(this.divd(this.divd(this.lit(5.0), this.lit(7.0)), this.sub(this.lit(7.0), this.mult(this.lit(2.0), this.lit(3.0))))).collect=== Seq(5.0, 7.0, 7.0, 2.0, 3.0));
        assert(convert(this.add(this.lit(0.0), this.lit(0.0))).collect=== Seq(0.0, 0.0));
        assert(convert(this.neg(this.lit(0.0))).collect=== Seq(0.0));
        assert(convert(this.mult(this.lit(1.0), this.lit(12.0))).collect=== Seq(1.0, 12.0));
        assert(convert(this.mult(this.lit(13.0), this.lit(1.0))).collect=== Seq(13.0, 1.0));
        assert("((5.0/2.0)*4.0)" === convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).prettyp);
        assert(10.0 === convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).eval)

        val h1 = this.mult(this.lit(3.0), this.lit(2.0));
        val h2 = this.mult(h1, h1);
        val threeDeep = this.mult(h2, h2);

        val mult1 = this.mult(lit(5.0), threeDeep);
        convert(mult1).truncate(1);
        assert( "(5.0*1296.0)" === convert(mult1).prettyp);

        val divd1 = this.divd(lit(5.0), threeDeep);
        convert(divd1).truncate(1);
        assert( "(5.0/1296.0)" === convert(divd1).prettyp);

        val neg1 = this.neg(threeDeep);
        convert(neg1).truncate(1);
        assert( "(-1296.0)" === convert(neg1).prettyp);

        val sub1 = this.sub(lit(5.0), threeDeep);
        convert(sub1).truncate(1);
        assert( "(5.0-1296.0)" === convert(sub1).prettyp);

        val base = this.mult(this.add(this.lit(3.0), this.lit(7.0)), this.lit(3.0));
        val baseBeforeTrunc = convert(base).prettyp;
        convert(base).truncate(3);
        assert(convert(base).prettyp === baseBeforeTrunc)

        val larger = this.sub(base, this.divd(base, this.lit(1.0)));
        val largerBeforeTrunc = convert(larger).prettyp;
        convert(larger).truncate(4);
        assert(convert(larger).prettyp === largerBeforeTrunc)

        val nd1 = this.neg(this.lit(1.0));
        val nd2 = this.neg(nd1);
        val nd3 = this.neg(nd2);
        assert( "(-(-(-1.0)))" === convert(nd3).prettyp);
        convert(nd3).truncate(2);

        // looks odd, but is right. The innermost one is the negation of -1.0
        assert( "(-(--1.0))" === convert(nd3).prettyp);

        convert(larger).truncate(3);
        val baseTrunc = this.mult(this.lit(10.0), this.lit(3.0));
        assert( convert(base).prettyp === convert(baseTrunc).prettyp);
        val largerTrunc = this.sub(baseTrunc, this.divd(baseTrunc, this.lit(1.0)));
        assert(convert(larger).prettyp === convert(largerTrunc).prettyp);
      }
    }

    class M4Test extends FunSuite { self =>

      object ActualTest extends TestTemplate[exp.m4.finalized.Exp] with finalized.Factory {
        val suite: FunSuite = self
      }

      test("M4") {
        ActualTest.test()
      }
    }
