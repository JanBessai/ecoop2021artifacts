package interpreter.ep;

import interpreter.ep.i1.MultByExp;
import org.junit.Assert;
import org.junit.Test;

public class I2Test extends I1Test {
    public interface TestTemplate extends I1Test.TestTemplate {
        default void test() {

            MultByExp pwr = power(lit(2.0), lit(5.0));
            MultByExp mb = pwr.multby(lit(4.0)); // mult by 4 just like raising by additional 2

            Assert.assertEquals(32.0, pwr.eval(), 0.0);
            Assert.assertEquals("(2.0^5.0)", pwr.prettyp());

            Assert.assertTrue("(2.0^(5.0+2.0))".equals(mb.prettyp()));
        }
    }

    static MultByExp lit(Double d) { return new interpreter.ep.i1.MultByLit(d); }
    static MultByExp add(MultByExp left, MultByExp right) { return new interpreter.ep.i1.MultByAdd(left, right); }
    static MultByExp sub(MultByExp left, MultByExp right) { return new interpreter.ep.i1.MultBySub(left, right); }
    static MultByExp power(MultByExp left, MultByExp right) { return new interpreter.ep.i2.EvalPrettypMultByPower(left, right); }

    private static class ActualTest implements M0Test.TestTemplate {}

    @Test
    public void testTest() { new I2Test.ActualTest().test(); }
}
