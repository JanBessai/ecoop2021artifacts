package trivially.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import trivially.ep.i1.*;

public class I2Test {
    public interface TestTemplate extends I1Test.TestTemplate {
        default void test() {
            I1Test.TestTemplate.super.test();

            Exp pwr = power(lit(2.0), lit(5.0));
            Exp mb = pwr.multby(lit(4.0)); //mult by 4 just like raising by additional 2

            Assertions.assertEquals(32.0, pwr.eval(), 0.0);
            Assertions.assertEquals("(2.0^5.0)", pwr.prettyp());

            //based upon the CONTEXT (M7I2 or I2) you might get different results for mb
            Assertions.assertTrue("(2.0^(5.0+2.0))".equals(mb.prettyp()) ||
                            "((2.0^5.0)*4.0)".equals(mb.prettyp()));
        }

        default Exp power(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.i2.finalized.Power((Exp)left, (Exp) right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
