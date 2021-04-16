package ev.ep;

import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.Sub;
import ev.ep.m3.*;

import ev.ep.m4.Collect;
import ev.ep.m4.Simplify;
import ev.ep.m4.Truncate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class M4Test {

    public interface TestTemplate extends M3Test.TestTemplate {
        default void test() {
            M3Test.TestTemplate.super.test();
            Divd expr1 = new Divd(new Lit(3.0), new Lit(1.0));
            Assertions.assertEquals("3.0", expr1.accept(makeSimplify()).accept(makePrettyp()));

            Divd expr2 = new Divd(new Lit(0.0), new Lit(2.0));
            Assertions.assertEquals("0.0", expr2.accept(makeSimplify()).accept(makePrettyp()));

            Divd expr3 = new Divd(new Lit(3.0), new Divd(new Lit(6.0), new Lit(2.0)));
            Assertions.assertEquals("1.0", expr3.accept(makeSimplify()).accept(makePrettyp()));

            Neg expr4 = new Neg(expr1);
            Assertions.assertEquals("(-3.0)", expr4.accept(makeSimplify()).accept(makePrettyp()));

            Add expr6 = new Add(new Lit(-2.0), new Lit(2.0));
            Assertions.assertEquals("0.0", expr6.accept(makeSimplify()).accept(makePrettyp()));

            Add expr7 = new Add(new Lit(-2.0), new Lit(0.0));
            Assertions.assertEquals("-2.0", expr7.accept(makeSimplify()).accept(makePrettyp()));

            Add expr8 = new Add(new Lit(-2.0), new Lit(-5.0));
            Assertions.assertEquals("(-2.0+-5.0)", expr8.accept(makeSimplify()).accept(makePrettyp()));

            Sub sub2 = new Sub(new Lit(3.0), new Lit(3.0));
            Assertions.assertEquals("0.0", sub2.accept(makeSimplify()).accept(makePrettyp()));

            Neg neg2 = new Neg(new Lit(0.0));
            Assertions.assertEquals("0.0", neg2.accept(makeSimplify()).accept(makePrettyp()));

            Mult left = new Mult(new Lit(3.0), new Lit(1.0));
            Mult right = new Mult(new Lit(1.0), new Lit(9.0));
            Divd expr5 = new Divd(left, right);
            Assertions.assertEquals("(3.0/9.0)", expr5.accept(makeSimplify()).accept(makePrettyp()));

            Assertions.assertEquals(new Divd(new Divd(new Lit(5.0), new Lit(7.0)), new Sub(new Lit(7.0), new Mult(new Lit(2.0), new Lit(3.0)))).accept(makeCollect()), Arrays.asList(5.0, 7.0, 7.0, 2.0, 3.0));
            Assertions.assertEquals(new Add(new Lit(0.0), new Lit(0.0)).accept(makeCollect()), Arrays.asList(0.0, 0.0));
            Assertions.assertEquals(new Neg(new Lit(0.0)).accept(makeCollect()), Collections.singletonList(0.0));
            Assertions.assertEquals(new Mult(new Lit(1.0), new Lit(12.0)).accept(makeCollect()), Arrays.asList(1.0, 12.0));
            Assertions.assertEquals(new Mult(new Lit(13.0), new Lit(1.0)).accept(makeCollect()), Arrays.asList(13.0, 1.0));
            Assertions.assertEquals("((5.0/2.0)*4.0)", new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(makePrettyp()));
            Assertions.assertEquals(10.0, new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(makeEval()), 0.0);

            Mult h1 = new Mult(new Lit(3.0), new Lit(2.0));
            Mult h2 = new Mult(h1, h1);
            Mult threeDeep = new Mult(h2, h2);

            Mult mult1 = new Mult(new Lit(5.0), threeDeep);
            mult1.accept(makeTruncate(1));
            Assertions.assertEquals("(5.0*1296.0)", mult1.accept(makePrettyp()));

            Divd divd1 = new Divd(new Lit(5.0), threeDeep);
            divd1.accept(makeTruncate(1));
            Assertions.assertEquals("(5.0/1296.0)", divd1.accept(makePrettyp()));

            Neg neg1 = new Neg(threeDeep);
            neg1.accept(makeTruncate(1));
            Assertions.assertEquals("(-1296.0)", neg1.accept(makePrettyp()));

            Sub sub1 = new Sub(new Lit(5.0), threeDeep);
            sub1.accept(makeTruncate(1));
            Assertions.assertEquals("(5.0-1296.0)", sub1.accept(makePrettyp()));

            Mult base = new Mult(new Add(new Lit(3.0), new Lit(7.0)), new Lit(3.0));
            String baseBeforeTrunc = base.accept(makePrettyp());
            base.accept(makeTruncate(3));
            Assertions.assertTrue(base.accept(makePrettyp()).equals(baseBeforeTrunc));

            Sub larger = new Sub(base, new Divd(base, new Lit(1.0)));
            String largerBeforeTrunc = larger.accept(makePrettyp());
            larger.accept(makeTruncate(4));
            Assertions.assertTrue(larger.accept(makePrettyp()).equals(largerBeforeTrunc));

            Neg nd1 = new Neg(new Lit(1.0));
            Neg nd2 = new Neg(nd1);
            Neg nd3 = new Neg(nd2);
            Assertions.assertEquals("(-(-(-1.0)))", nd3.accept(makePrettyp()));
            nd3.accept(makeTruncate(2));

            // looks odd, but is right. The innermost one is the negation of -1.0
            Assertions.assertEquals("(-(--1.0))", nd3.accept(makePrettyp()));

            larger.accept(makeTruncate(3));
            Mult baseTrunc = new Mult(new Lit(10.0), new Lit(3.0));
            Assertions.assertEquals( base.accept(makePrettyp()), baseTrunc.accept(makePrettyp()));
            Sub largerTrunc = new Sub(baseTrunc, new Divd(baseTrunc, new Lit(1.0)));
            Assertions.assertEquals(larger.accept(makePrettyp()), largerTrunc.accept(makePrettyp()));
        }

        default Visitor<Double> makeEval() {
            return new EvalDivdMultNeg();
        }
        default Visitor<String> makePrettyp() {
            return new PrettypDivdMultNeg();
        }
        default Visitor<Exp> makeSimplify() {
            return new Simplify();
        }
        default Visitor<Void> makeTruncate(int level) {
            return new Truncate(level);
        }
        default Visitor<java.util.List<Double>> makeCollect() {
            return new Collect();
        }
    }

    private static class ActualTest implements M1Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
