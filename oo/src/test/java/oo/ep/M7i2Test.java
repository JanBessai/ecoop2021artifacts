package oo.ep;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class M7i2Test {
    public interface TestTemplate extends M7Test.TestTemplate, I2Test.TestTemplate{
        default void test() {
            M7Test.TestTemplate.super.test();
            I2Test.TestTemplate.super.test();

            Exp m = new Mult(new Lit(2.0), new Lit(5.0));
            Exp mb = m.multby(new Lit(4.0));

            Exp pwr = new Power(new Lit(2.0), new Lit(5.0));
            Exp pwr2 = new Lit(2.0).powby(new Lit(5.0));

            Assert.assertFalse(pwr.eql(mb));
            Assert.assertFalse(mb.eql(pwr));

            Assert.assertTrue(pwr.equals(pwr2));
            Assert.assertTrue(pwr.eql(pwr2));
            Assert.assertTrue(pwr2.eql(pwr));

            Exp neg = new Neg(new Lit(2.0));
            Exp neg2 = neg.powby(new Lit(5.0));
            Assert.assertEquals(-32.0, neg2.eval(), 0.0);

            Exp neg3 = neg.multby(new Lit(5.0));
            Assert.assertEquals(-10.0, neg3.eval(), 0.0);

            Exp divd2 = new Divd(new Lit(6.0), new Lit(2.0)).multby(new Lit(5.0));
            Assert.assertEquals(15.0, divd2.eval(), 0.0);

            Assert.assertEquals(40.0, mb.eval(), 0.0);
            Assert.assertEquals("((2.0*5.0)*4.0)", mb.prettyp());

            Exp expr1 = new Power(new Lit(3.0), new Lit(1.0));
            Assert.assertEquals("3.0", expr1.simplify().prettyp());

            Exp  expr2 = new Power(new Lit(1.0), new Lit(2.0));
            Assert.assertEquals("1.0", expr2.simplify().prettyp());

            Exp  expr3 = new Power(new Lit(3.0), new Lit(2.0));
            Assert.assertEquals("(3.0^2.0)", expr3.simplify().prettyp());

            // 43046721 = ((9^2)^2)^2
            Exp h1 = new Power(new Lit(43046721.0), new Lit(0.5));
            Exp h2 = new Power(h1, new Lit(0.5));
            Exp threeDeep = new Power(h2, new Lit(0.5));

            Exp pwr1 = new Power(new Lit(5.0), threeDeep);
            pwr1.truncate(1);
            Assert.assertEquals("(5.0^9.0)", pwr1.prettyp());

            Assert.assertEquals(new Power(new Lit(1.0), new Lit(12.0)).collect(), Arrays.asList(1.0, 12.0));

            Exp pwr3 = new Power(new Lit(2.0), new Lit(3.0));
            Exp pwr4 = pwr3.powby(new Lit(4.0));
            Assert.assertEquals("((2.0^3.0)^4.0)", pwr4.prettyp());
        }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
