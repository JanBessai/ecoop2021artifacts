package ev.ep;

import ev.ep.m0.Lit;
import ev.ep.m1.EvalSub;
import ev.ep.m1.Sub;
import org.junit.Assert;
import org.junit.Test;

public class M1Test extends M0Test {

    public static class TestTemplate {
        void test() {

            Sub expr1 = new Sub(new Lit(1.0), new Lit(2.0));
            Assert.assertEquals(-1.0, expr1.<Double>accept(this.makeEval()), 0.0);

            Lit expr2 = new Lit(2.0);
            Assert.assertEquals(2.0, expr2.<Double>accept(this.makeEval()), 0.0);
            Assert.assertEquals(new Sub(new Lit(1.0), new Lit(2.0)).<Double>accept(this.makeEval()), -1.0, 0.0);
        }

        public EvalSub makeEval() {
            return new EvalSub();
        }
    }
    
    @Test
    public void testTest() { new TestTemplate().test(); }
}
