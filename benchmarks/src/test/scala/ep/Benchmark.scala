package ep

import coco.ep.m7i2.finalized
import ev.ep.m7i2.{EvalMerged, SimplifyMerged}
import exp.m7alt2.finalized
import interpreter.ep.m7i2.{MergedLit, MergedPower, MergedSub}
import org.scalameter.KeyValue
import org.scalameter.api._

object Benchmark extends Bench.OfflineReport {
  val testConfig: Seq[KeyValue] = Seq[KeyValue](
    exec.benchRuns -> 1000,
    exec.independentSamples -> 10
  )

  val sizes: Gen[Int] = Gen.range("size")(0, 13, 1)

  val evalBase = 1.0
  val evalExponent = 1.0001

  object cocoScalaObjects extends exp.m7alt2.finalized.Factory {
    import exp._
    val startEval: Exp[m7alt2.finalized.Exp] = this.power(this.lit(evalBase), this.lit(evalExponent))
    val evalExps: Gen[Exp[m7alt2.finalized.Exp]] = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => this.power(current, current)))
    val startSimplify: Exp[m7alt2.finalized.Exp] = sub(lit(5.0), lit(0.0))
    val simplifyExps: Gen[Exp[m7alt2.finalized.Exp]] = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => power(current, current)))
  }

  object cocoObjects extends coco.ep.m7i2.finalized.Factory {
    import coco.ep._
    val startEval: Exp[m7i2.finalized.Exp] = this.power(this.lit(evalBase), this.lit(evalExponent))
    val evalExps: Gen[Exp[m7i2.finalized.Exp]] = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => this.power(current, current)))
    val startSimplify: Exp[m7i2.finalized.Exp] = sub(lit(5.0), lit(0.0))
    val simplifyExps: Gen[Exp[m7i2.finalized.Exp]] = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => power(current, current)))
  }
  object ooObjects {
    import oo.ep._
    val startEval: Exp = new Power(new Lit(evalBase), new Lit(evalExponent))
    val evalExps: Gen[Exp] = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => new Power(current, current)))
    val startSimplify: Exp = new Sub(new Lit(5.0), new Lit(0.0))
    val simplifyExps: Gen[Exp] = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => new Power(current, current)))
  }
  object evObjects {
    import ev.ep._
    import ev.ep.i2.Power
    import ev.ep.m0.Lit
    import ev.ep.m1.Sub

    val startEval: Exp = new Power(new Lit(evalBase), new Lit(evalExponent))
    val evalExps: Gen[Exp] = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => new Power(current, current)))
    val startSimplify: Exp = new Sub(new Lit(5.0), new Lit(0.0))
    val simplifyExps: Gen[Exp] = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => new Power(current, current)))
  }
object interpreterObjects {
    import interpreter.ep.m7i2.MergedExp
    val startEval: MergedExp = new MergedPower(new MergedLit(evalBase), new MergedLit(evalExponent))
    val evalExps: Gen[MergedExp] = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => new MergedPower(current, current)))
    val startSimplify: MergedExp = new MergedSub(new MergedLit(5.0), new MergedLit(0.0))
    val simplifyExps: Gen[MergedExp] = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => new MergedPower(current, current)))
  }
  object triviallyObjects  {
    import trivially.ep.m7i2.Exp
    import trivially.ep.m7i2.finalized._
    val startEval: Exp = new Power(new Lit(1.0), new Lit(evalExponent))
    val evalExps:Gen[trivially.ep.m7i2.Exp] = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => new Power(current, current)))
    val startSimplify: Exp = new Sub(new Lit(5.0), new Lit(0.0))
    val simplifyExps: Gen[Exp] = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => new Power(current, current)))
  }

  performance of "eval" config(testConfig:_*) in {
    measure method "coco_scala" in {
      using(cocoScalaObjects.evalExps) in { exp =>
        cocoScalaObjects.convert(exp).eval
      }
    }
    measure method "coco" in {
      using(cocoObjects.evalExps) in { exp =>
        cocoObjects.convert(exp).eval()
      }
    }
    measure method "trivially" in {
      using(cocoObjects.evalExps) in { exp =>
        exp.getSelf.eval()
      }
    }
    measure method "oo" in {
      using(ooObjects.evalExps) in { exp =>
        exp.eval()
      }
    }
    measure method "ev" in {
      using(evObjects.evalExps) in { exp =>
        exp.accept(new EvalMerged)
      }
    }
    measure method "interpreter" in {
      using(interpreterObjects.evalExps) in { exp =>
        exp.eval()
      }
    }
  }

  performance of "simplify" config(testConfig:_*) in {
    measure method "coco_scala" in {
      using(cocoScalaObjects.simplifyExps) in { exp =>
        cocoScalaObjects.convert(exp).simplify
      }
    }
    measure method "coco" in {
      using(cocoObjects.simplifyExps) in { exp =>
        cocoObjects.convert(exp).simplify()
      }
    }
    measure method "trivially" in {
      using(cocoObjects.simplifyExps) in { exp =>
        exp.getSelf.simplify()
      }
    }
    measure method "oo" in {
      using(ooObjects.simplifyExps) in { exp =>
        exp.simplify()
      }
    }
    measure method "ev" in {
      using(evObjects.simplifyExps) in { exp =>
        exp.accept(new SimplifyMerged)
      }
    }
    measure method "interpreter" in {
      using(interpreterObjects.simplifyExps) in { exp =>
        exp.simplify()
      }
    }
  }
}