package interpreter.ep;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.i2.EvalPrettypMultByExpFactory;
import org.junit.Assert;
import org.junit.Test;

public class I2Test  {
    public static class TestTemplate extends EvalPrettypMultByExpFactory {
        void test() {

            MultByExp pwr = power(lit(2.0), lit(5.0));
            MultByExp mb = pwr.multby(lit(4.0)); // mult by 4 just like raising by additional 2

            Assert.assertEquals(32.0, pwr.eval(), 0.0);
            Assert.assertEquals("(2.0^5.0)", pwr.prettyp());

            //based upon the CONTEXT (M7I2 or I2) you might get different results for mb
            System.out.println(mb.prettyp());
            Assert.assertTrue("(2.0^(5.0+2.0))".equals(mb.prettyp()) ||
                            "((2.0^5.0)*4.0)".equals(mb.prettyp()));
        }
    }

    @Test
    public void testTest() {
        new I1Test().testTest();
        new TestTemplate().test();
    }
}
