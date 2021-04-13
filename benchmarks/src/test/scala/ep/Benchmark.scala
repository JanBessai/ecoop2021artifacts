package ep

import coco.ep.m7i2.finalized
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

  object cocoObjects extends coco.ep.m7i2.finalized.Factory {
    import coco.ep._
    val startEval: Exp[m7i2.finalized.Exp] = this.power(this.lit(evalBase), this.lit(evalExponent))
    val evalExps: Gen[Exp[finalized.Exp]] = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => this.power(current, current)))
    val startSimplify: Exp[m7i2.finalized.Exp] = sub(lit(5.0), lit(0.0))
    val simplifyExps: Gen[Exp[finalized.Exp]] = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => power(current, current)))
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
    import ev.ep.m7i2.Power
    import ev.ep.m7i2.Lit
    import ev.ep.m7i2.Sub

    val startEval: Exp = new Power(new Lit(evalBase), new Lit(evalExponent))
    val evalExps: Gen[Exp] = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => new Power(current, current)))
    val startSimplify: Exp = new Sub(new Lit(5.0), new Lit(0.0))
    val simplifyExps: Gen[Exp] = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => new Power(current, current)))
  }
object interpreterObjects {
    import interpreter.ep.m7i2.MergedExp
    val startEval: MergedExp = interpreter.ep.m7i2.MergedExpFactory.power(interpreter.ep.m7i2.MergedExpFactory.lit(evalBase), interpreter.ep.m7i2.MergedExpFactory.lit(evalExponent))
    val evalExps: Gen[MergedExp] = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => interpreter.ep.m7i2.MergedExpFactory.power(current, current)))
    val startSimplify: MergedExp = interpreter.ep.m7i2.MergedExpFactory.sub(interpreter.ep.m7i2.MergedExpFactory.lit(5.0), interpreter.ep.m7i2.MergedExpFactory.lit(0.0))
    val simplifyExps: Gen[MergedExp] = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => interpreter.ep.m7i2.MergedExpFactory.power(current, current)))
  }
  object triviallyObjects  {
    import trivially.ep.m7i2.Exp
    import trivially.ep.m7i2.finalized._
    val startEval: Exp[Visitor] = new Power(new Lit(1.0), new Lit(evalExponent))
    val evalExps:Gen[trivially.ep.m7i2.Exp[trivially.ep.m7i2.finalized.Visitor]] = sizes.map(size => (0 until size).foldLeft(startEval)((current, _) => new Power(current, current)))
    val startSimplify: Exp[Visitor] = new Sub(new Lit(5.0), new Lit(0.0))
    val simplifyExps: Gen[Exp[Visitor]] = sizes.map(size => (0 until size).foldLeft(startSimplify)((current, _) => new Power(current, current)))
  }

  performance of "eval" config(testConfig:_*) in {
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
        exp.accept(new ev.ep.m7i2.EvalDivdMultNegTruncateEqualPower)
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
        exp.accept(new ev.ep.m7i2.SimplifyPower)
      }
    }
    measure method "interpreter" in {
      using(interpreterObjects.simplifyExps) in { exp =>
        exp.simplify()
      }
    }
  }
}