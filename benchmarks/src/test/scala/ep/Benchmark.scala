package ep

import ev.ep.i2.{EvalPower, Power}
import ev.ep.m0.Lit
import ev.ep.m1.Sub
import ev.ep.m7i2.SimplifyPower
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
object interpreterObjects {
    import interpreter.ep.m7i2.MergedExp
    val startEval: MergedExp = interpreter.ep.m7i2.MergedExpFactory.power(interpreter.ep.m7i2.MergedExpFactory.lit(1.0), interpreter.ep.m7i2.MergedExpFactory.lit(1.0001))
    val evalExps = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => interpreter.ep.m7i2.MergedExpFactory.power(current, current)))
    val startSimplify: MergedExp = interpreter.ep.m7i2.MergedExpFactory.sub(interpreter.ep.m7i2.MergedExpFactory.lit(1.0), interpreter.ep.m7i2.MergedExpFactory.lit(1.0))
    val simplifyExps = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => interpreter.ep.m7i2.MergedExpFactory.power(current, current)))
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
        exp.accept(new EvalPower)
      }
    }
    measure method "interpreter" in {
      using(interpreterObjects.evalExps) in { exp =>
        exp.eval()
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
        exp.accept(new SimplifyPower)
      }
    }
    measure method "interpreter" in {
      using(interpreterObjects.simplifyExps) in { exp =>
        exp.simplify()
      }
    }
  }
}