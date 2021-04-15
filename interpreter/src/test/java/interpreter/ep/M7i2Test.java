package interpreter.ep;

import interpreter.ep.m0.EvalExp;
import interpreter.ep.m2.PrettypExp;
import interpreter.ep.m7i2.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class M7i2Test {
    public interface TestTemplate extends M7Test.TestTemplate,I2Test.TestTemplate {
        default void test() {
            M7Test.TestTemplate.super.test();
            I2Test.TestTemplate.super.test();

            MergedExp m = mult(lit(2.0), lit(5.0));
            MergedExp mb = (MergedExp) m.multby(lit(4.0));

            MergedExp pwr = power(lit(2.0), lit(5.0));
            MergedExp pwr2 = (MergedExp) lit(2.0).powby(lit(5.0));

            Assert.assertFalse(pwr.eql(mb));
            Assert.assertFalse(mb.eql(pwr));

            Assert.assertTrue(pwr.equals(pwr2));
            Assert.assertTrue(pwr.eql(pwr2));
            Assert.assertTrue(pwr2.eql(pwr));

            MergedExp neg = neg(lit(2.0));
            MergedExp neg2 = (MergedExp) neg.powby(lit(5.0));
            Assert.assertEquals(-32.0, neg2.eval(), 0.0);

            MergedExp neg3 = (MergedExp) neg.multby(lit(5.0));
            Assert.assertEquals(-10.0, neg3.eval(), 0.0);

            MergedExp divd2 = (MergedExp) divd(lit(6.0), lit(2.0)).multby(lit(5.0));
            Assert.assertEquals(15.0, divd2.eval(), 0.0);

            Assert.assertEquals(40.0, mb.eval(), 0.0);
            Assert.assertEquals("((2.0*5.0)*4.0)", mb.prettyp());

            MergedExp expr1 = power(lit(3.0), lit(1.0));
            Assert.assertEquals("3.0", expr1.simplify().prettyp());

            MergedExp expr2 = power(lit(1.0), lit(2.0));
            Assert.assertEquals("1.0", expr2.simplify().prettyp());

            MergedExp expr3 = power(lit(3.0), lit(2.0));
            Assert.assertEquals("(3.0^2.0)", expr3.simplify().prettyp());

            // 43046721 = ((9^2)^2)^2
            MergedExp h1 = power(lit(43046721.0), lit(0.5));
            MergedExp h2 = power(h1, lit(0.5));
            MergedExp threeDeep = power(h2, lit(0.5));

            MergedExp pwr1 = power(lit(5.0), threeDeep);
            pwr1.truncate(1);
            Assert.assertEquals("(5.0^9.0)", pwr1.prettyp());

            Assert.assertEquals(power(lit(1.0), lit(12.0)).collect(), Arrays.asList(1.0, 12.0));

            MergedExp pwr3 = power(lit(2.0), lit(3.0));
            MergedExp pwr4 = (MergedExp) pwr3.powby(lit(4.0));
            Assert.assertEquals("((2.0^3.0)^4.0)", pwr4.prettyp());
        }

        @Override default MergedExp lit(Double d) { return new interpreter.ep.m7i2.MergedLit(d); }
        @Override default MergedExp add(EvalExp left, EvalExp right) { return new interpreter.ep.m7i2.MergedAdd((MergedExp) left, (MergedExp) right); }
        @Override default MergedExp sub(EvalExp left, EvalExp right) { return new interpreter.ep.m7i2.MergedSub((MergedExp) left, (MergedExp) right); }
        @Override default MergedExp mult(PrettypExp left, PrettypExp right) { return new interpreter.ep.m7i2.MergedMult((MergedExp) left, (MergedExp) right); }
        @Override default MergedExp neg(PrettypExp inner) { return new interpreter.ep.m7i2.MergedNeg((MergedExp) inner); }
        @Override default MergedExp divd(PrettypExp left, PrettypExp right) { return new interpreter.ep.m7i2.MergedDivd((MergedExp) left, (MergedExp) right); }
        default MergedExp power(MergedExp left, MergedExp right) { return new interpreter.ep.m7i2.MergedPower(left, right); }
    }

     private static class ActualTest implements M7i2Test.TestTemplate {}

    @Test
    public void testTest() { new M7i2Test.ActualTest().test(); }
}
