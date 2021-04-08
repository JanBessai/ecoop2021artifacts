package interpreter.ep;

import interpreter.ep.m0.EvalExp;
import interpreter.ep.m0.EvalExpFactory;
import org.junit.Assert;
import org.junit.Test;

public class M0Test {
    public static class TestTemplate extends EvalExpFactory {
        void test() {
            EvalExp expr1 = add(lit(1.0), lit(2.0));
            Assert.assertEquals(3.0, expr1.eval(), 0.0);

            EvalExp expr2 = lit(2.0);
            Assert.assertEquals(2.0, expr2.eval(), 0.0);

            Assert.assertEquals(3.0, add(lit(1.0), lit(2.0)).eval(), 0.0);
            Assert.assertEquals(5.0, lit(5.0).eval(), 0.0);
        }
    }
    @Test
    public void testTest() { new TestTemplate().test(); }
}
