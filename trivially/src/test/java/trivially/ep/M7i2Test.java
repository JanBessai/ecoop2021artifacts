package trivially.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

            Assertions.assertFalse(pwr.eql(mb));
            Assertions.assertFalse(mb.eql(pwr));

            Assertions.assertTrue(pwr.equals(pwr2));
            Assertions.assertTrue(pwr.eql(pwr2));
            Assertions.assertTrue(pwr2.eql(pwr));

            Exp neg = neg(lit(2.0));
            Exp neg2 = neg.powby(lit(5.0));
            Assertions.assertEquals(-32.0, neg2.eval(), 0.0);

            Exp neg3 = neg.multby(lit(5.0));
            Assertions.assertEquals(-10.0, neg3.eval(), 0.0);

            Exp divd2 = divd(lit(6.0), lit(2.0)).multby(lit(5.0));
            Assertions.assertEquals(15.0, divd2.eval(), 0.0);

            Assertions.assertEquals(40.0, mb.eval(), 0.0);
            Assertions.assertEquals("((2.0*5.0)*4.0)", mb.prettyp());

            Exp expr1 = power(lit(3.0), lit(1.0));
            Assertions.assertEquals("3.0", expr1.simplify().prettyp());

            Exp  expr2 = power(lit(1.0), lit(2.0));
            Assertions.assertEquals("1.0", expr2.simplify().prettyp());

            Exp  expr3 = power(lit(3.0), lit(2.0));
            Assertions.assertEquals("(3.0^2.0)", expr3.simplify().prettyp());

            // 43046721 = ((9^2)^2)^2
            Exp h1 = power(lit(43046721.0), lit(0.5));
            Exp h2 = power(h1, lit(0.5));
            Exp threeDeep = power(h2, lit(0.5));

            Exp pwr1 = power(lit(5.0), threeDeep);
            pwr1.truncate(1);
            Assertions.assertEquals("(5.0^9.0)", pwr1.prettyp());

            Assertions.assertEquals(power(lit(1.0), lit(12.0)).collect(), Arrays.asList(1.0, 12.0));

            Exp pwr3 = power(lit(2.0), lit(3.0));
            Exp pwr4 = pwr3.powby(lit(4.0));
            Assertions.assertEquals("((2.0^3.0)^4.0)", pwr4.prettyp());
        }

        @Override default Exp lit(Double d) { return new trivially.ep.m7i2.finalized.Lit(d); }
        @Override default Exp add(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m7i2.finalized.Add((Exp) left, (Exp) right); }
        @Override default Exp sub(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m7i2.finalized.Sub((Exp) left, (Exp) right); }
        @Override default Exp mult(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m7i2.finalized.Mult((Exp) left, (Exp) right); }
        @Override default Exp neg(trivially.ep.m0.Exp inner) { return new trivially.ep.m7i2.finalized.Neg((Exp) inner); }
        @Override default Exp divd(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m7i2.finalized.Divd((Exp) left, (Exp) right); }
        default Power power(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m7i2.finalized.Power((Exp) left, (Exp) right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
