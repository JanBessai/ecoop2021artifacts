package coco.ep;

import org.junit.Assert;
import org.junit.Test;

public class I2Test {
    public interface TestTemplate<FT> extends coco.ep.i2.Factory<FT>, I1Test.TestTemplate<FT> {
        default void test() {
            I1Test.TestTemplate.super.test();

            Exp<FT> pwr = this.power(this.lit(2.0), this.lit(5.0));
            Exp<FT> mb = convert(pwr).multby(this.lit(4.0)); //mult by 4 just like raising by additional 2

            Assert.assertEquals(32.0, convert(pwr).eval(), 0.0);
            Assert.assertEquals("(2.0^5.0)", convert(pwr).prettyp());

            //based upon the CONTEXT (M7I2 or I2) you might get different results for mb
            Assert.assertTrue("(2.0^(5.0+2.0))".equals(convert(mb).prettyp()) ||
                            "((2.0^5.0)*4.0)".equals(convert(mb).prettyp()));
        }
    }
    private static class ActualTest implements I2Test.TestTemplate<coco.ep.i1.finalized.Exp>, coco.ep.i2.finalized.Factory {}

    @Test
    public void testTest() { new I2Test.ActualTest().test(); }
}
