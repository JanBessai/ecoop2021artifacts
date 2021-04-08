package oo.ep;

import org.junit.Assert;
import org.junit.Test;

public class I2Test {
    public interface TestTemplate extends I1Test.TestTemplate {
        default void test() {
            I1Test.TestTemplate.super.test();

            Exp pwr = new Power(new Lit(2.0), new Lit(5.0));
            Exp mb = pwr.multby(new Lit(4.0)); //mult by 4 just like raising by additional 2

            Assert.assertEquals(32.0, pwr.eval(), 0.0);
            Assert.assertEquals("(2.0^5.0)", pwr.prettyp());

            //based upon the CONTEXT (M7I2 or I2) you might get different results for mb
            Assert.assertTrue("(2.0^(5.0+2.0))".equals(mb.prettyp()) ||
                            "((2.0^5.0)*4.0)".equals(mb.prettyp()));
        }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
