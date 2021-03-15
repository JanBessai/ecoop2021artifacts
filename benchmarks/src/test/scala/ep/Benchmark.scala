package ep
import org.scalameter.KeyValue
import org.scalameter.api._

object EvalBenchmark extends Bench.OfflineReport {
  val testConfig = Seq[KeyValue](
    exec.benchRuns -> 1000,
    exec.independentSamples -> 10
  )

  val sizes: Gen[Int] = Gen.range("size")(0, 13, 1)

  object cocoObjects extends coco.ep.m7i2.finalized.Factory {
    import coco.ep._
    val startEval: Exp[m7i2.finalized.Exp] = this.power(this.lit(1.0), this.lit(1.0001))
    val evalExps = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => this.power(current, current)))
    val startSimplify: Exp[m7i2.finalized.Exp] = sub(lit(1.0), lit(1.0))
    val simplifyExps = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => power(current, current)))
  }
  object ooObjects {
    import oo.ep._
    val startEval: Exp = new Power(new Lit(1.0), new Lit(1.0001))
    val evalExps = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => new Power(current, current)))
    val startSimplify: Exp = new Sub(new Lit(1.0), new Lit(1.0))
    val simplifyExps = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => new Power(current, current)))
  }
  object evObjects {
    import ev.ep._
    val startEval: Exp = new Power(new Lit(1.0), new Lit(1.0001))
    val evalExps = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => new Power(current, current)))
    val startSimplify: Exp = new Sub(new Lit(1.0), new Lit(1.0))
    val simplifyExps = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => new Power(current, current)))
  }
  object vitaObjects extends vita.ep.m7i2.finalized.Factory {
    import vita.ep._
    val startEval: m7i2.Exp[m7i2.finalized.Visitor] = this.power(this.lit(1.0), this.lit(1.0001))
    val evalExps = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => this.power(current, current)))
    val startSimplify: m7i2.Exp[m7i2.finalized.Visitor] = sub(lit(1.0), lit(1.0))
    val simplifyExps = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => power(current, current)))
  }

  performance of "eval" config(testConfig:_*) in {
    measure method "coco" in {
      using(cocoObjects.evalExps) in { exp =>
        cocoObjects.convert(exp).eval()
      }
    }
    measure method "oo" in {
      using(ooObjects.evalExps) in { exp =>
        exp.eval()
      }
    }
    measure method "ev" in {
      using(evObjects.evalExps) in { exp =>
        exp.accept(new ev.ep.EvalPower)
      }
    }
    measure method "vita" in {
      using(vitaObjects.evalExps) in { exp =>
        vitaObjects.convert(exp).eval()
      }
    }
  }
  performance of "simplify" config(testConfig:_*) in {
    measure method "coco" in {
      using(cocoObjects.simplifyExps) in { exp =>
        cocoObjects.convert(exp).simplify()
      }
    }
    measure method "oo" in {
      using(ooObjects.simplifyExps) in { exp =>
        exp.simplify()
      }
    }
    measure method "ev" in {
      using(evObjects.simplifyExps) in { exp =>
        exp.accept(new ev.ep.SimplifyPower)
      }
    }
    measure method "vita" in {
      using(vitaObjects.simplifyExps) in { exp =>
        exp.simplify()
      }
    }
  }
}