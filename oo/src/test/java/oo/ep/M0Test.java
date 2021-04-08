package oo.ep;

import org.junit.Assert;
import org.junit.Test;

public class M0Test {
    public interface TestTemplate  {
        default void test() {
            Exp expr1 = new Add(new Lit(1.0), new Lit(2.0));
            Assert.assertEquals(3.0, expr1.eval(), 0.0);

            Exp expr2 = new Lit(2.0);
            Assert.assertEquals(2.0, expr2.eval(), 0.0);

            Assert.assertEquals(3.0, new Add(new Lit(1.0), new Lit(2.0)).eval(), 0.0);
            Assert.assertEquals(5.0, new Lit(5.0).eval(), 0.0);
        }
    }

    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
