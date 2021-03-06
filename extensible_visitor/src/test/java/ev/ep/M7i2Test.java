package ev.ep;

import ev.ep.i2.Power;
import ev.ep.m0.Lit;
import ev.ep.m3.Divd;
import ev.ep.m3.Mult;
import ev.ep.m3.Neg;
import ev.ep.m7i2.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class M7i2Test {

    // clash when attempting to extend both I2Test.TestTemplate and M7TestTemplate
    public interface TestTemplate extends M7Test.TestTemplate, I2Test.TestTemplate {
        default void test() {
            M7Test.TestTemplate.super.test();
            I2Test.TestTemplate.super.test();

            Mult m = new Mult(new Lit(2.0), new Lit(5.0));
            Exp mb = m.accept(makeMultBy(new Lit(4.0)));

            Exp pwr = new Power(new Lit(2.0), new Lit(5.0));
            Exp pwr2 = new Lit(2.0).accept(makePowby(new Lit(5.0)));

            Assertions.assertFalse(pwr.accept(makeEql(mb)));
            Assertions.assertFalse(mb.accept(makeEql(pwr)));

            Assertions.assertTrue(pwr.accept(makeEql(pwr2)));
            Assertions.assertTrue(pwr2.accept(makeEql(pwr)));

            Neg neg = new Neg(new Lit(2.0));
            Exp neg2 = neg.accept(makePowby(new Lit(5.0)));
            Assertions.assertEquals(-32.0, neg2.accept(makeEval()), 0.0);

            Exp neg3 = neg.accept(makeMultBy(new Lit(5.0)));
            Assertions.assertEquals(-10.0, neg3.accept(makeEval()), 0.0);

            Exp divd2 = new Divd(new Lit(6.0), new Lit(2.0)).accept(makeMultBy(new Lit(5.0)));
            Assertions.assertEquals(15.0, divd2.accept(makeEval()), 0.0);

            Assertions.assertEquals(40.0, mb.accept(makeEval()), 0.0);
            Assertions.assertEquals("((2.0*5.0)*4.0)", mb.accept(makePrettyp()));

            Exp expr1 = new Power(new Lit(3.0), new Lit(1.0));
            Assertions.assertEquals("3.0", expr1.accept(makeSimplify()).accept(makePrettyp()));

            Exp expr2 = new Power(new Lit(1.0), new Lit(2.0));
            Assertions.assertEquals("1.0", expr2.accept(makeSimplify()).accept(makePrettyp()));

            Exp expr3 = new Power(new Lit(3.0), new Lit(2.0));
            Assertions.assertEquals("(3.0^2.0)", expr3.accept(makeSimplify()).accept(makePrettyp()));

            // 43046721 = ((9^2)^2)^2
            Exp h1 = new Power(new Lit(43046721.0), new Lit(0.5));
            Exp h2 = new Power(h1, new Lit(0.5));
            Exp threeDeep = new Power(h2, new Lit(0.5));

            Exp pwr1 = new Power(new Lit(5.0), threeDeep);
            pwr1.accept(makeTruncate(1));
            Assertions.assertEquals("(5.0^9.0)", pwr1.accept(makePrettyp()));

            Assertions.assertEquals(new Power(new Lit(1.0), new Lit(12.0)).accept(makeCollect()), Arrays.asList(1.0, 12.0));

            Exp pwr3 = new Power(new Lit(2.0), new Lit(3.0));
            Exp pwr4 = pwr3.accept(makePowby(new Lit(4.0)));
            Assertions.assertEquals("((2.0^3.0)^4.0)", pwr4.accept(makePrettyp()));
        }

        default VisitorMerged<Double> makeEval() {
            return new EvalMerged();
        }
        default VisitorMerged<Exp> makeSimplify() {
            return new SimplifyMerged();
        }
        default VisitorMerged<String> makePrettyp() { return new PrettypMerged(); }
        default VisitorMerged<Boolean> makeEql(Exp exp) { return new EqlMerged(exp); }
        default VisitorMerged<Boolean> makeEquals(Exp exp) { return new EqualsMerged(exp); }
        default VisitorMerged<Exp> makeMultBy (Exp other) {
            return new MultByMerged(other);
        }
        default VisitorMerged<Exp> makePowby(Exp exp) { return new PowByMerged(exp); }
        default VisitorMerged<java.util.List<Double>> makeCollect() { return new CollectMerged(); }
        default VisitorMerged<Void> makeTruncate(int level) { return new TruncateMerged(level); }
    }

    private static class ActualTest implements M7i2Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
