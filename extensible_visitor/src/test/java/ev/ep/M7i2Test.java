package ev.ep;

import ev.ep.m6.Eql;
import ev.ep.m7i2.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class M7i2Test {

    public static class TestTemplate {
        void test() {

            Mult m = new Mult(new Lit(2.0), new Lit(5.0));
            EqlQuery mb = (EqlQuery) m.accept(makeMultBy(new Lit(4.0)));

            EqlQuery pwr = new Power(new Lit(2.0), new Lit(5.0));
            Exp sss = new Lit(2.0).accept(makePowby(new Lit(5.0)));
            EqlQuery pwr2 = (EqlQuery) sss;

            Assert.assertFalse(pwr.accept(makeEql(mb)));
            Assert.assertFalse(mb.accept(makeEql(pwr)));

            Assert.assertTrue(pwr.accept(makeEql(pwr2)));
            Assert.assertTrue(pwr2.accept(makeEql(pwr)));

            Neg neg = new Neg(new Lit(2.0));
            Exp neg2 = neg.accept(makePowby(new Lit(5.0)));
            Assert.assertEquals(-32.0, neg2.accept(makeEval()), 0.0);

            Exp neg3 = neg.accept(makeMultBy(new Lit(5.0)));
            Assert.assertEquals(-10.0, neg3.accept(makeEval()), 0.0);

            Exp divd2 = new Divd(new Lit(6.0), new Lit(2.0)).accept(makeMultBy(new Lit(5.0)));
            Assert.assertEquals(15.0, divd2.accept(makeEval()), 0.0);

            Assert.assertEquals(40.0, mb.accept(makeEval()), 0.0);
            Assert.assertEquals("((2.0*5.0)*4.0)", mb.accept(makePrettyp()));

            Exp expr1 = new Power(new Lit(3.0), new Lit(1.0));
            Assert.assertEquals("3.0", expr1.accept(makeSimplify()).accept(makePrettyp()));

            Exp expr2 = new Power(new Lit(1.0), new Lit(2.0));
            Assert.assertEquals("1.0", expr2.accept(makeSimplify()).accept(makePrettyp()));

            Exp expr3 = new Power(new Lit(3.0), new Lit(2.0));
            Assert.assertEquals("(3.0^2.0)", expr3.accept(makeSimplify()).accept(makePrettyp()));

            // 43046721 = ((9^2)^2)^2
            Exp h1 = new Power(new Lit(43046721.0), new Lit(0.5));
            Exp h2 = new Power(h1, new Lit(0.5));
            Exp threeDeep = new Power(h2, new Lit(0.5));

            Exp pwr1 = new Power(new Lit(5.0), threeDeep);
            pwr1.accept(makeTruncate(1));
            Assert.assertEquals("(5.0^9.0)", pwr1.accept(makePrettyp()));

            Assert.assertEquals(new Power(new Lit(1.0), new Lit(12.0)).accept(makeCollect()), Arrays.asList(1.0, 12.0));

            Exp pwr3 = new Power(new Lit(2.0), new Lit(3.0));
            Exp pwr4 = pwr3.accept(makePowby(new Lit(4.0)));
            Assert.assertEquals("((2.0^3.0)^4.0)", pwr4.accept(makePrettyp()));
        }

        public SimplifyPower makeSimplify() {
            return new SimplifyPower();
        }

        public EqlPower makeEql(EqlQuery exp) { return new EqlPower((Exp)exp); }
        public PrettypPower makePrettyp () {
            return new PrettypPower();
        }
        public MultByPower makeMultBy (Exp other) {
            return new MultByPower(other);
        }
        public EvalDivdMultNegTruncateEqualPower makeEval() {
            return new EvalDivdMultNegTruncateEqualPower();
        }
        public PowByPower makePowby(Exp exp) { return new PowByPower(exp); }
        public CollectPower makeCollect() { return new CollectPower(); }
        public TruncatePower makeTruncate(int level) {
            return new TruncatePower(level);
        }
    }
    @Test
    public void testTest() { new TestTemplate().test(); }
}
