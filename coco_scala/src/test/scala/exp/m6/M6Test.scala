package exp.m6

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

    assert(lit1.equals(lit1))
    assert(!lit1.equals(lit2))
    assert(mult1.equals(mult1))
    assert(!mult1.equals(divd1))
    assert(divd1.equals(divd1))
    assert(!divd1.equals(add1))
    assert(add1.equals(add1))
    assert(!add1.equals(sub1))
    assert(sub1.equals(sub1))
    assert(!sub1.equals(neg1))
    assert(neg1.equals(neg1))
    assert(!neg1.equals(mult1))

    assert(lit1.eql(lit1))
    assert(!lit1.eql(lit2))
    assert(mult1.eql(mult1))
    assert(!mult1.eql(divd1))
    assert(divd1.eql(divd1))
    assert(!divd1.eql(add1))
    assert(add1.eql(add1))
    assert(!add1.eql(sub1))
    assert(sub1.eql(sub1))
    assert(!sub1.eql(neg1))
    assert(neg1.eql(neg1))
    assert(!neg1.eql(mult1))

    assert(this.sub(this.lit(1.0), this.lit(73.0)).equals(this.sub(this.lit(1.0), this.lit(73.0))))
    assert(!this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(3.0))))
    assert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))))
    assert(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).equals(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))))
    assert(!this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)).equals(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))))
    assert(!this.divd(this.lit(6.0), this.lit(2.0)).equals(this.divd(this.lit(8.0), this.lit(2.0))))
    assert(this.divd(this.lit(6.0), this.lit(2.0)).equals(this.divd(this.lit(6.0), this.lit(2.0))))
    assert(this.add(this.lit(5.0), this.lit(3.0)).equals(this.add(this.lit(5.0), this.lit(3.0))))
    assert(!this.add(this.lit(5.0), this.lit(3.0)).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(3.0))))
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
