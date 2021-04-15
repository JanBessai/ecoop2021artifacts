package oo.ep;

import org.junit.Assert;
import org.junit.Test;

public class M7Test {

    public interface TestTemplate extends M6Test.TestTemplate {
        default void test() {
            M6Test.TestTemplate.super.test();

            Exp pby = new Lit(3.0).powby(new Lit(2.0));
            Exp d1 = new Divd(new Lit(5.0), new Lit(2.0)).powby(new Lit(2.0));
            Exp m1 = new Mult(new Lit(5.0), new Lit(2.0)).powby(new Lit(2.0));
            Exp a1 = new Add(new Lit(5.0), new Lit(2.0)).powby(new Lit(2.0));
            Exp s1 = new Sub(new Lit(5.0), new Lit(3.0)).powby(new Lit(2.0));
            Exp n1 = new Neg(new Lit(5.0)).powby(new Lit(2.0));

            Assert.assertEquals(9.0, pby.eval(), 0.0);
            Assert.assertEquals(6.25, d1.eval(), 0.0);
            Assert.assertEquals(100.0, m1.eval(), 0.0);
            Assert.assertEquals(49.0, a1.eval(), 0.0);
            Assert.assertEquals(4.0, s1.eval(), 0.0);
            Assert.assertEquals(25.0, n1.eval(), 0.0);

            Assert.assertEquals(1000.0, new Lit(10.0).powby_old(new Lit(3.0)).eval(), 0.0);

            Assert.assertEquals(28561.0, new Add(new Lit(1.0), new Lit(12.0)).powby(new Lit(4.0)).eval(), 0.0);
        }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
