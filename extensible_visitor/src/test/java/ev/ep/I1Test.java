package ev.ep;

import ev.ep.i1.MultBy;
import ev.ep.m1.EvalSub;
import ev.ep.m0.Lit;
import ev.ep.m0.Add;
import ev.ep.m1.Sub;
import org.junit.Assert;
import org.junit.Test;

public class I1Test extends M0Test {

    public static class TestTemplate {
        void test() {
            Assert.assertEquals(-3.0, new Sub(new Lit(1.0), new Lit(2.0)).accept(makeMultBy(new Lit(3.0))).accept(makeEval()), 0.0);
            Assert.assertEquals(9.0, new Add(new Lit(1.0), new Lit(2.0)).accept(makeMultBy(new Lit(3.0))).accept(makeEval()), 0.0);
        }

        public EvalSub makeEval() {
            return new EvalSub();
        }
        public MultBy makeMultBy (Exp other) {
            return new MultBy(other);
        }
    }
    
    @Test
    public void testTest() { new TestTemplate().test(); }
}
