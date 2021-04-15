package ev.ep;

import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.Sub;
import ev.ep.m3.Divd;
import ev.ep.m3.EvalDivdMultNeg;
import ev.ep.m3.Mult;
import ev.ep.m3.Neg;
import ev.ep.m7.PowBy;
import org.junit.Assert;
import org.junit.Test;

public class M7Test {

    public interface TestTemplate extends M6Test.TestTemplate {
        default void test() {
            M6Test.TestTemplate.super.test();

            Exp pby = new Lit(3.0).accept(makePowby(new Lit(2.0)));
            Exp d1 = new Divd(new Lit(5.0), new Lit(2.0)).accept(makePowby(new Lit(2.0)));
            Exp m1 = new Mult(new Lit(5.0), new Lit(2.0)).accept(makePowby(new Lit(2.0)));
            Exp a1 = new Add(new Lit(5.0), new Lit(2.0)).accept(makePowby(new Lit(2.0)));
            Exp s1 = new Sub(new Lit(5.0), new Lit(3.0)).accept(makePowby(new Lit(2.0)));
            Exp n1 = new Neg(new Lit(5.0)).accept(makePowby(new Lit(2.0)));

            Assert.assertEquals(9.0, pby.accept(makeEval()), 0.0);
            Assert.assertEquals(6.25, d1.accept(makeEval()), 0.0);
            Assert.assertEquals(100.0, m1.accept(makeEval()), 0.0);
            Assert.assertEquals(49.0, a1.accept(makeEval()), 0.0);
            Assert.assertEquals(4.0, s1.accept(makeEval()), 0.0);
            Assert.assertEquals(25.0, n1.accept(makeEval()), 0.0);

            Assert.assertEquals(28561.0, new Add(new Lit(1.0), new Lit(12.0)).accept(makePowby(new Lit(4.0))).accept(makeEval()), 0.0);
        }
    }

    static EvalDivdMultNeg makeEval() {
        return new EvalDivdMultNeg();
    }
    static PowBy makePowby(Exp exp) { return new PowBy(exp); }

    private static class ActualTest implements M7Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
