package interpreter.ep;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.i2.EvalPrettypMultByPower;
import interpreter.ep.m0.EvalExp;
import org.junit.Assert;
import org.junit.Test;

public class I2Test {
    public interface TestTemplate extends I1Test.TestTemplate {
        default void test() {

            MultByExp pwr = power(lit(2.0), lit(5.0));
            MultByExp mb = pwr.multby(lit(4.0)); // mult by 4 just like raising by additional 2

            Assert.assertEquals(32.0, pwr.eval(), 0.0);
            Assert.assertEquals("(2.0^5.0)", pwr.prettyp());

            Assert.assertTrue("(2.0^(5.0+2.0))".equals(mb.prettyp()));
        }

        @Override default MultByExp lit(Double d) { return new interpreter.ep.i1.MultByLit(d); }
        @Override default MultByExp add(EvalExp left, EvalExp right) { return new interpreter.ep.i1.MultByAdd((MultByExp) left, (MultByExp) right); }
        @Override default MultByExp sub(EvalExp left, EvalExp right) { return new interpreter.ep.i1.MultBySub((MultByExp) left, (MultByExp) right); }
        default MultByExp power(MultByExp left, MultByExp right) { return new EvalPrettypMultByPower(left, right); }
    }

    private static class ActualTest implements I2Test.TestTemplate {}

    @Test
    public void testTest() { new I2Test.ActualTest().test(); }
}
