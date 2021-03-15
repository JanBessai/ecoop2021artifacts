package ep
import org.scalameter.api._

object EvalBenchmark extends Bench.LocalTime {
  override def reporter = new org.scalameter.api.HtmlReporter()

  val sizes = Gen.range("size")(0, 11, 1)
  object cocoObjects extends coco.ep.m7i2.finalized.Factory {
    import coco.ep._
    val startEval: Exp[m7i2.finalized.Exp] = this.power(this.lit(1.0), this.lit(1.0001))
    val evalExps = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => this.power(current, current)))
    val startSimplify: Exp[m7i2.finalized.Exp] = sub(lit(1.0), lit(1.0))
    val simplifyExps = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => power(current, current)))
  }
  performance of "eval" in {
    measure method "coco/eval" in {
      using(coco.evalExps) in { exp =>
        cocoObjects.convert(exp).eval()
      }
    }
  }
  performance of "simplify" in {
    measure method "coco/simplify" in {
      using(cocoObjects.simplifyExps) in { exp =>
        cocoObjects.convert(exp).simplify()
      }
    }
  }
}