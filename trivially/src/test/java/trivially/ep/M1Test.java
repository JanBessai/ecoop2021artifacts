package trivially.ep;

import org.junit.Assert;
import org.junit.Test;
import trivially.ep.m0.Exp;
import trivially.ep.m1.finalized.Sub;

public class M1Test {

    public interface TestTemplate extends M0Test.TestTemplate {
        default void test() {
            M0Test.TestTemplate.super.test();

            Exp expr1 = sub(lit(1.0), lit(2.0));
            Assert.assertEquals(-1.0, expr1.eval(), 0.0);

            Exp expr2 = lit(2.0);
            Assert.assertEquals(2.0, expr2.eval(), 0.0);
            Assert.assertEquals(sub(lit(1.0), lit(2.0)).eval(), -1.0, 0.0);
        }

        default Sub sub(Exp left, Exp right) { return new trivially.ep.m1.finalized.Sub(left, right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
