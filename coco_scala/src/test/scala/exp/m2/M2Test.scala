  package exp.m2

  import org.scalatest.FunSuite

  trait TestTemplate[FT] extends Factory[FT] with exp.m1.TestTemplate[FT] {
    val suite:FunSuite
    import suite._

    override def test() : Unit = {
      super.test()

     val expr1 = this.add(this.lit(1.0), this.lit(2.0))
     assert("(1.0+2.0)" === expr1.prettyp)

     val expr2 = this.lit(2.0)
     assert("2.0" === expr2.prettyp)

     assert("(1.0-2.0)" === convert(this.sub(this.lit(1.0), this.lit(2.0))).prettyp)
     assert( "((1.0-2.0)+(5.0+6.0))" === convert(this.add(this.sub(this.lit(1.0), this.lit(2.0)), this.add(this.lit(5.0), this.lit(6.0)))).prettyp)
    }
  }

  class M2Test extends FunSuite { self =>

    object ActualTest extends TestTemplate[exp.m2.finalized.Exp] with finalized.Factory {
      val suite: FunSuite = self
    }

    test("M2") {
      ActualTest.test()
    }
  }
