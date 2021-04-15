package ev.ep;

import ev.ep.m0.Add;
import ev.ep.m0.Eval;
import ev.ep.m0.Lit;
import org.junit.Assert;
import org.junit.Test;

public class M0Test {
    public interface TestTemplate {

        default void test() {
            Add expr1 = new Add(new Lit(1.0), new Lit(2.0));
            Assert.assertEquals(3.0, expr1.<Double>accept(makeEval()), 0.0);

            Lit expr2 = new Lit(2.0);
            Assert.assertEquals(2.0, expr2.<Double>accept(makeEval()), 0.0);

            Assert.assertEquals(3.0, new Add(new Lit(1.0), new Lit(2.0)).<Double>accept(makeEval()), 0.0);
            Assert.assertEquals(5.0, new Lit(5.0).<Double>accept(makeEval()), 0.0);

            Assert.assertEquals(3.0, new Add(new Lit(1.0), new Lit(2.0)).<Double>accept(makeEval()), 0.0);
            Assert.assertEquals(5.0, new Lit(5.0).<Double>accept(makeEval()), 0.0);
        }
    }

    static Eval makeEval() {
        return new Eval();
    }

    @Test
    public void testTest() { new TestTemplate(){}.test(); }
}
