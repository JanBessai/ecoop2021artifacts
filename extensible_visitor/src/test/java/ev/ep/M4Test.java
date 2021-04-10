package ev.ep;

import ev.ep.m4.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class M4Test {

    public static class TestTemplate {
        void test() {

            Divd expr1 = new Divd(new Lit(3.0), new Lit(1.0));
            Assert.assertEquals("3.0", expr1.accept(this.makeSimplify()).accept(this.makePrettyp()));

            Divd expr2 = new Divd(new Lit(0.0), new Lit(2.0));
            Assert.assertEquals("0.0", expr2.accept(this.makeSimplify()).accept(this.makePrettyp()));

            Divd expr3 = new Divd(new Lit(3.0), new Divd(new Lit(6.0), new Lit(2.0)));
            Assert.assertEquals("1.0", expr3.accept(this.makeSimplify()).accept(this.makePrettyp()));

            Neg expr4 = new Neg(expr1);
            Assert.assertEquals("(-3.0)", expr4.accept(this.makeSimplify()).accept(this.makePrettyp()));

            Add expr6 = new Add(new Lit(-2.0), new Lit(2.0));
            Assert.assertEquals("0.0", expr6.accept(this.makeSimplify()).accept(this.makePrettyp()));

            Add expr7 = new Add(new Lit(-2.0), new Lit(0.0));
            Assert.assertEquals("-2.0", expr7.accept(this.makeSimplify()).accept(this.makePrettyp()));

            Add expr8 = new Add(new Lit(-2.0), new Lit(-5.0));
            Assert.assertEquals("(-2.0+-5.0)", expr8.accept(this.makeSimplify()).accept(this.makePrettyp()));

            Sub sub2 = new Sub(new Lit(3.0), new Lit(3.0));
            Assert.assertEquals("0.0", sub2.accept(this.makeSimplify()).accept(this.makePrettyp()));

            Neg neg2 = new Neg(new Lit(0.0));
            Assert.assertEquals("0.0", neg2.accept(this.makeSimplify()).accept(this.makePrettyp()));

            Mult left = new Mult(new Lit(3.0), new Lit(1.0));
            Mult right = new Mult(new Lit(1.0), new Lit(9.0));
            Divd expr5 = new Divd(left, right);
            Assert.assertEquals("(3.0/9.0)", expr5.accept(this.makeSimplify()).accept(this.makePrettyp()));

            Assert.assertEquals(new Divd(new Divd(new Lit(5.0), new Lit(7.0)), new Sub(new Lit(7.0), new Mult(new Lit(2.0), new Lit(3.0)))).accept(this.makeCollect()), Arrays.asList(5.0, 7.0, 7.0, 2.0, 3.0));
            Assert.assertEquals(new Add(new Lit(0.0), new Lit(0.0)).accept(this.makeCollect()), Arrays.asList(0.0, 0.0));
            Assert.assertEquals(new Neg(new Lit(0.0)).accept(this.makeCollect()), Collections.singletonList(0.0));
            Assert.assertEquals(new Mult(new Lit(1.0), new Lit(12.0)).accept(this.makeCollect()), Arrays.asList(1.0, 12.0));
            Assert.assertEquals(new Mult(new Lit(13.0), new Lit(1.0)).accept(this.makeCollect()), Arrays.asList(13.0, 1.0));
            Assert.assertEquals("((5.0/2.0)*4.0)", new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(this.makePrettyp()));
            Assert.assertEquals(10.0, new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(this.makeEval()), 0.0);

            Mult h1 = new Mult(new Lit(3.0), new Lit(2.0));
            Mult h2 = new Mult(h1, h1);
            Mult threeDeep = new Mult(h2, h2);

            Mult mult1 = new Mult(new Lit(5.0), threeDeep);
            mult1.accept(this.makeTruncate(1));
            Assert.assertEquals("(5.0*1296.0)", mult1.accept(this.makePrettyp()));

            Divd divd1 = new Divd(new Lit(5.0), threeDeep);
            divd1.accept(this.makeTruncate(1));
            Assert.assertEquals("(5.0/1296.0)", divd1.accept(this.makePrettyp()));

            Neg neg1 = new Neg(threeDeep);
            neg1.accept(this.makeTruncate(1));
            Assert.assertEquals("(-1296.0)", neg1.accept(this.makePrettyp()));

            Sub sub1 = new Sub(new Lit(5.0), threeDeep);
            sub1.accept(this.makeTruncate(1));
            Assert.assertEquals("(5.0-1296.0)", sub1.accept(this.makePrettyp()));

            Mult base = new Mult(new Add(new Lit(3.0), new Lit(7.0)), new Lit(3.0));
            String baseBeforeTrunc = base.accept(this.makePrettyp());
            base.accept(this.makeTruncate(3));
            Assert.assertTrue("", base.accept(this.makePrettyp()).equals(baseBeforeTrunc));

            Sub larger = new Sub(base, new Divd(base, new Lit(1.0)));
            String largerBeforeTrunc = larger.accept(this.makePrettyp());
            larger.accept(this.makeTruncate(4));
            Assert.assertTrue("", larger.accept(this.makePrettyp()).equals(largerBeforeTrunc));

            Neg nd1 = new Neg(new Lit(1.0));
            Neg nd2 = new Neg(nd1);
            Neg nd3 = new Neg(nd2);
            Assert.assertEquals("(-(-(-1.0)))", nd3.accept(this.makePrettyp()));
            nd3.accept(this.makeTruncate(2));

            // looks odd, but is right. The innermost one is the negation of -1.0
            Assert.assertEquals("(-(--1.0))", nd3.accept(this.makePrettyp()));

            larger.accept(this.makeTruncate(3));
            Mult baseTrunc = new Mult(new Lit(10.0), new Lit(3.0));
            Assert.assertEquals( base.accept(this.makePrettyp()), baseTrunc.accept(this.makePrettyp()));
            Sub largerTrunc = new Sub(baseTrunc, new Divd(baseTrunc, new Lit(1.0)));
            Assert.assertEquals(larger.accept(this.makePrettyp()), largerTrunc.accept(this.makePrettyp()));
        }

        public EvalDivdMultNegTruncate makeEval() {
            return new EvalDivdMultNegTruncate();
        }

        public PrettypDivdMultNegTruncate makePrettyp() {
            return new PrettypDivdMultNegTruncate();
        }

        public Simplify makeSimplify() {
            return new Simplify();
        }

        public Truncate makeTruncate(int level) {
            return new Truncate(level);
        }

        public Collect makeCollect() {
            return new Collect();
        }
    }
    @Test
    public void testTest() { new TestTemplate().test(); }
}
