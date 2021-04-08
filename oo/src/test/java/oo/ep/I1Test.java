package oo.ep;

import org.junit.Assert;
import org.junit.Test;

public class I1Test {
    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();

            Assert.assertEquals(-3.0, new Sub(new Lit(1.0), new Lit(2.0)).multby(new Lit(3.0)).eval(), 0.0);

            Assert.assertEquals(9.0, new Add(new Lit(1.0), new Lit(2.0)).multby(new Lit(3.0)).eval(), 0.0);
        }
    }
    private static class ActualTest implements TestTemplate {}


    @Test
    public void testTest() { new ActualTest().test(); }
}
