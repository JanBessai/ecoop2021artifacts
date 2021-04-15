package trivially.ep;

import org.junit.Assert;
import org.junit.Test;
import trivially.ep.m7i2.*;

import java.util.Arrays;

public class M7i2Test {
    public interface TestTemplate extends M7Test.TestTemplate, I2Test.TestTemplate {
        default void test() {
            M7Test.TestTemplate.super.test();
            I2Test.TestTemplate.super.test();

            Exp m = mult(lit(2.0), lit(5.0));
            Exp mb = m.multby(lit(4.0));

            Exp pwr = power(lit(2.0), lit(5.0));
            Exp pwr2 = lit(2.0).powby(lit(5.0));

            Assert.assertFalse(pwr.eql(mb));
            Assert.assertFalse(mb.eql(pwr));

            Assert.assertTrue(pwr.equals(pwr2));
            Assert.assertTrue(pwr.eql(pwr2));
            Assert.assertTrue(pwr2.eql(pwr));

            Exp neg = neg(lit(2.0));
            Exp neg2 = neg.powby(lit(5.0));
            Assert.assertEquals(-32.0, neg2.eval(), 0.0);

            Exp neg3 = neg.multby(lit(5.0));
            Assert.assertEquals(-10.0, neg3.eval(), 0.0);

            Exp divd2 = divd(lit(6.0), lit(2.0)).multby(lit(5.0));
            Assert.assertEquals(15.0, divd2.eval(), 0.0);

            Assert.assertEquals(40.0, mb.eval(), 0.0);
            Assert.assertEquals("((2.0*5.0)*4.0)", mb.prettyp());

            Exp expr1 = power(lit(3.0), lit(1.0));
            Assert.assertEquals("3.0", expr1.simplify().prettyp());

            Exp  expr2 = power(lit(1.0), lit(2.0));
            Assert.assertEquals("1.0", expr2.simplify().prettyp());

            Exp  expr3 = power(lit(3.0), lit(2.0));
            Assert.assertEquals("(3.0^2.0)", expr3.simplify().prettyp());

            // 43046721 = ((9^2)^2)^2
            Exp h1 = power(lit(43046721.0), lit(0.5));
            Exp h2 = power(h1, lit(0.5));
            Exp threeDeep = power(h2, lit(0.5));

            Exp pwr1 = power(lit(5.0), threeDeep);
            pwr1.truncate(1);
            Assert.assertEquals("(5.0^9.0)", pwr1.prettyp());

            Assert.assertEquals(power(lit(1.0), lit(12.0)).collect(), Arrays.asList(1.0, 12.0));

            Exp pwr3 = power(lit(2.0), lit(3.0));
            Exp pwr4 = pwr3.powby(lit(4.0));
            Assert.assertEquals("((2.0^3.0)^4.0)", pwr4.prettyp());
        }

        default Lit lit(Double d) { return new trivially.ep.m7i2.finalized.Lit(d); }
        default Add add(Exp left, Exp right) { return new trivially.ep.m7i2.finalized.Add(left, right); }
        default Sub sub(Exp left, Exp right) { return new trivially.ep.m7i2.finalized.Sub(left, right); }
        default Mult mult(Exp left, Exp right) { return new trivially.ep.m7i2.finalized.Mult(left, right); }
        default Neg neg(Exp inner) { return new trivially.ep.m7i2.finalized.Neg(inner); }
        default Divd divd(Exp left, Exp right) { return new trivially.ep.m7i2.finalized.Divd(left, right); }

        default Power power(Exp left, Exp right) { return new trivially.ep.m7i2.finalized.Power(left, right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
