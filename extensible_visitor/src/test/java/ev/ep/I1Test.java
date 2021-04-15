package ev.ep;

import ev.ep.i1.MultBy;
import ev.ep.m1.EvalSub;
import ev.ep.m0.Lit;
import ev.ep.m0.Add;
import ev.ep.m1.Sub;
import org.junit.Assert;
import org.junit.Test;

public class I1Test extends M0Test {

    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();

            Assert.assertEquals(-3.0, new Sub(new Lit(1.0), new Lit(2.0)).accept(makeMultBy(new Lit(3.0))).accept(makeEval()), 0.0);
            Assert.assertEquals(9.0, new Add(new Lit(1.0), new Lit(2.0)).accept(makeMultBy(new Lit(3.0))).accept(makeEval()), 0.0);
        }

    }

    static EvalSub makeEval() { return new EvalSub();}
    static MultBy makeMultBy (Exp other) {
        return new MultBy(other);
    }

    private static class ActualTest implements I1Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
