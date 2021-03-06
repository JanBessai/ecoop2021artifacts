package exp.m5

import org.scalatest.FunSuite

trait TestTemplate[FT] extends Factory[FT] with exp.m4.TestTemplate[FT] {
  val suite:FunSuite
  import suite._

  override def test() : Unit = {
    super.test()

    val lit1 = this.lit(1.0)
    val lit2 = this.lit(2.0)
    val mult1 = this.mult(lit1, lit2)
    val divd1 = this.divd(lit1, lit2)
    val add1 = this.add(lit1, lit2)
    val sub1 = this.sub(lit1, lit2)
    val neg1 = this.neg(lit1)

    assert(lit1.id === lit2.id)
    assert(mult1.id === this.mult(lit1, lit2).id)
    assert(divd1.id === this.divd(lit1, lit2).id)
    assert(sub1.id === this.sub(lit1, lit2).id)
    assert(add1.id === this.add(lit1, lit2).id)
    assert(neg1.id === this.neg(lit2).id)

    val n1 = new Node(lit1.id, new Leaf(1.0))
    val n2 = new Node(lit2.id, new Leaf(2.0))
    val m3 = new Node(mult1.id, n1, n2)
    assert(m3 === this.mult(lit1, lit2).astree)

    val d3 = new Node(divd1.id, n1, n2)
    assert(d3 === this.divd(lit1, lit2).astree)

    val n3 = new Node(neg1.id, n1)
    assert(n3 === this.neg(lit1).astree)

    val a3 = new Node(add1.id, n1, n2)
    assert(a3 === this.add(lit1, lit2).astree)

    val s3 = new Node(sub1.id, n1, n2)
    assert(s3 === this.sub(lit1, lit2).astree)

    assert(this.sub(this.neg(this.lit(2.0)), this.mult(this.sub(this.lit(1.0), this.lit(976.0)), this.add(this.mult(this.lit(1.0), this.lit(976.0)), this.divd(this.lit(1.0), this.lit(3.0))))).astree.equals(new Node(83488, new Node(78192, new Node(76407, new Leaf(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf(1.0)), new Node(76407, new Leaf(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf(1.0)), new Node(76407, new Leaf(976.0))), new Node(2130451, new Node(76407, new Leaf(1.0)), new Node(76407, new Leaf(3.0))))))))
    assert(this.sub(this.neg(this.lit(2.0)), this.mult(this.sub(this.lit(1.0), this.lit(976.0)), this.add(this.mult(this.lit(1.0), this.lit(976.0)), this.divd(this.lit(1.0), this.lit(3.0))))).prettyp.equals("((-2.0)-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))"))
    assert(this.mult(this.mult(this.lit(2.0), this.lit(1.0)), this.add(this.lit(0.0), this.lit(7.0))).simplify.astree.equals(new Node(2409808, new Node(76407, new Leaf(2.0)), new Node(76407, new Leaf(7.0)))))
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
