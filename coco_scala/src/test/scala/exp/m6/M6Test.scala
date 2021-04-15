    package exp.m6

import org.scalatest.FunSuite

    trait TestTemplate[FT] extends Factory[FT] with exp.m4.TestTemplate[FT] {
      val suite:FunSuite
      import suite._

      override def test() : Unit = {
        super.test()


        val lit1 = convert(this.lit(1.0));
        val lit2 = convert(this.lit(2.0));
        val mult1 = convert(this.mult(lit1, lit2));
        val divd1 = convert(this.divd(lit1, lit2));
        val add1 = convert(this.add(lit1, lit2));
        val sub1 = convert(this.sub(lit1, lit2));
        val neg1 = convert(this.neg(lit1));
        
        assert(convert(lit1).equals(convert(lit1)));
        assert(!convert(lit1).equals(convert(lit2)));
        assert(convert(mult1).equals(convert(mult1)));
        assert(!convert(mult1).equals(convert(divd1)));
        assert(convert(divd1).equals(convert(divd1)));
        assert(!convert(divd1).equals(convert(add1)));
        assert(convert(add1).equals(convert(add1)));
        assert(!convert(add1).equals(convert(sub1)));
        assert(convert(sub1).equals(convert(sub1)));
        assert(!convert(sub1).equals(convert(neg1)));
        assert(convert(neg1).equals(convert(neg1)));
        assert(!convert(neg1).equals(convert(mult1)));

        assert(convert(lit1).eql(convert(lit1)));
        assert(!convert(lit1).eql(convert(lit2)));
        assert(!convert(mult1).eql(convert(lit2)));
        assert(convert(mult1).eql(convert(mult1)));
        assert(!convert(mult1).eql(convert(divd1)));
        assert(convert(divd1).eql(convert(divd1)));
        assert(!convert(divd1).eql(convert(add1)));
        assert(convert(add1).eql(convert(add1)));
        assert(!convert(add1).eql(convert(sub1)));
        assert(convert(sub1).eql(convert(sub1)));
        assert(!convert(sub1).eql(convert(neg1)));
        assert(convert(neg1).eql(convert(neg1)));
        assert(!convert(neg1).eql(convert(mult1)));

        assert(convert(this.sub(this.lit(1.0), this.lit(73.0))).equals(this.sub(this.lit(1.0), this.lit(73.0))));
        assert(!convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(3.0))));
        assert(convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))));
        assert(convert(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))).equals(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))));
        assert(!convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).equals(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))));
        assert(!convert(this.divd(this.lit(6.0), this.lit(2.0))).equals(this.divd(this.lit(8.0), this.lit(2.0))));
        assert(convert(this.divd(this.lit(6.0), this.lit(2.0))).equals(this.divd(this.lit(6.0), this.lit(2.0))));
        assert(convert(this.add(this.lit(5.0), this.lit(3.0))).equals(this.add(this.lit(5.0), this.lit(3.0))));
        assert(!convert(this.add(this.lit(5.0), this.lit(3.0))).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(3.0))));

      }
    }

    class M6Test extends FunSuite { self =>

      object ActualTest extends TestTemplate[exp.m6.finalized.Exp] with finalized.Factory {
        val suite: FunSuite = self
      }

      test("M6") {
        ActualTest.test()
      }
    }
