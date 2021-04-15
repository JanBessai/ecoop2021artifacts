    package exp.m5

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

        assert(lit1.id === lit2.id)
        assert(mult1.id === convert(this.mult(lit1, lit2)).id);
        assert(convert(divd1).id === convert(this.divd(lit1, lit2)).id);
        assert(convert(sub1).id === convert(this.sub(lit1, lit2)).id);
        assert(convert(add1).id === convert(this.add(lit1, lit2)).id);
        assert(convert(neg1).id === convert(this.neg(lit2)).id);

        val n1 = new Node(lit1.id, new Leaf(1.0))
        val n2 = new Node(lit2.id, new Leaf(2.0))
        val m3 = new Node(mult1.id, n1, n2)
        assert(m3 === convert(this.mult(lit1, lit2)).astree);

        val d3 = new Node(divd1.id, n1, n2)
        assert(d3 === convert(this.divd(lit1, lit2)).astree);

        val n3 = new Node(neg1.id, n1)
        assert(n3 === convert(this.neg(lit1)).astree);

        val a3 = new Node(add1.id, n1, n2);
        assert(a3 === convert(this.add(lit1, lit2)).astree);

        val s3 = new Node(sub1.id, n1, n2);
        assert(s3 === convert(this.sub(lit1, lit2)).astree);

        assert(convert(this.sub(this.neg(this.lit(2.0)), this.mult(this.sub(this.lit(1.0), this.lit(976.0)), this.add(this.mult(this.lit(1.0), this.lit(976.0)), this.divd(this.lit(1.0), this.lit(3.0)))))).astree.equals(new Node(83488, new Node(78192, new Node(76407, new Leaf(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf(1.0)), new Node(76407, new Leaf(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf(1.0)), new Node(76407, new Leaf(976.0))), new Node(2130451, new Node(76407, new Leaf(1.0)), new Node(76407, new Leaf(3.0))))))));
        assert(convert(this.sub(this.neg(this.lit(2.0)), this.mult(this.sub(this.lit(1.0), this.lit(976.0)), this.add(this.mult(this.lit(1.0), this.lit(976.0)), this.divd(this.lit(1.0), this.lit(3.0)))))).prettyp.equals("((-2.0)-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))"));
        assert(convert(convert(this.mult(this.mult(this.lit(2.0), this.lit(1.0)), this.add(this.lit(0.0), this.lit(7.0)))).simplify).astree.equals(new Node(2409808, new Node(76407, new Leaf(2.0)), new Node(76407, new Leaf(7.0)))));
        
      }
    }

    class M5Test extends FunSuite { self =>

      object ActualTest extends TestTemplate[exp.m5.finalized.Exp] with finalized.Factory {
        val suite: FunSuite = self
      }

      test("M5") {
        ActualTest.test()
      }
    }
