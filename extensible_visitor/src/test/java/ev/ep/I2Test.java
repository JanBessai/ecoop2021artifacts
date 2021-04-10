package ev.ep;

import ev.ep.i2.EvalPower;
import ev.ep.i2.MultByPower;
import ev.ep.i2.Power;
import ev.ep.i2.PrettypPower;
import ev.ep.m0.Lit;
import org.junit.Assert;
import org.junit.Test;

public class I2Test extends M0Test {

    public static class TestTemplate {
        void test() {

            Power pwr = new Power(new Lit(2.0), new Lit(5.0));
            Exp mb = pwr.accept(makeMultBy(new Lit(4.0))); //mult by 4 just like raising by additional 2

            Assert.assertEquals(32.0, pwr.accept(makeEval()), 0.0);
            Assert.assertEquals("(2.0^5.0)", pwr.accept(makePrettyp()));

            System.out.println(mb.accept(makePrettyp()));
            //based upon the CONTEXT (M7I2 or I2) you might get different results for mb
            Assert.assertTrue("(2.0^(5.0+2.0))".equals(mb.accept(makePrettyp())) ||
                            "((2.0^5.0)*4.0)".equals(mb.accept(makePrettyp())));
        }

        public EvalPower makeEval() {
            return new EvalPower();
        }
        public PrettypPower makePrettyp () {
            return new PrettypPower();
        }
        public MultByPower makeMultBy (Exp other) {
            return new MultByPower(other);
        }
    }

    @Test
    public void testTest() { new TestTemplate().test(); }
}
