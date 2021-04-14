package trivially.ep;

import org.junit.Assert;
import org.junit.Test;
import trivially.ep.m4.Add;
import trivially.ep.m4.Lit;
import trivially.ep.m4.Sub;
import trivially.ep.m4.Exp;
import trivially.ep.m4.Divd;
import trivially.ep.m4.Mult;
import trivially.ep.m4.Neg;

import java.util.Arrays;
import java.util.Collections;

public class M4Test {
    public interface TestTemplate extends M3Test.TestTemplate {
        default void test() {
            M3Test.TestTemplate.super.test();

            Exp expr1 = divd(lit(3.0), lit(1.0));
            Assert.assertEquals("3.0", expr1.simplify().prettyp());

            Exp expr2 = divd(lit(0.0), lit(2.0));
            Assert.assertEquals("0.0", expr2.simplify().prettyp());

            Exp expr3 = divd(lit(3.0), divd(lit(6.0), lit(2.0)));
            Assert.assertEquals("1.0", expr3.simplify().prettyp());

            Exp expr4 = neg(expr1);
            Assert.assertEquals("(-3.0)", expr4.simplify().prettyp());

            Exp expr6 = add(lit(-2.0), lit(2.0));
            Assert.assertEquals("0.0", expr6.simplify().prettyp());

            Exp expr7 = add(lit(-2.0), lit(0.0));
            Assert.assertEquals("-2.0", expr7.simplify().prettyp());

            Exp expr8 = add(lit(-2.0), lit(-5.0));
            Assert.assertEquals("(-2.0+-5.0)", expr8.simplify().prettyp());

            Exp sub2 = sub(lit(3.0), lit(3.0));
            Assert.assertEquals("0.0", sub2.simplify().prettyp());

            Exp neg2 = neg(lit(0.0));
            Assert.assertEquals("0.0", neg2.simplify().prettyp());

            Exp left = mult(lit(3.0), lit(1.0));
            Exp right = mult(lit(1.0), lit(9.0));
            Exp expr5 = divd(left, right);
            Assert.assertEquals("(3.0/9.0)", expr5.simplify().prettyp());

            Assert.assertEquals(divd(divd(lit(5.0), lit(7.0)), sub(lit(7.0), mult(lit(2.0), lit(3.0)))).collect(), Arrays.asList(5.0, 7.0, 7.0, 2.0, 3.0));
            Assert.assertEquals(add(lit(0.0), lit(0.0)).collect(), Arrays.asList(0.0, 0.0));
            Assert.assertEquals(neg(lit(0.0)).collect(), Collections.singletonList(0.0));
            Assert.assertEquals(mult(lit(1.0), lit(12.0)).collect(), Arrays.asList(1.0, 12.0));
            Assert.assertEquals(mult(lit(13.0), lit(1.0)).collect(), Arrays.asList(13.0, 1.0));
            Assert.assertEquals("((5.0/2.0)*4.0)", mult(divd(lit(5.0), lit(2.0)), lit(4.0)).prettyp());
            Assert.assertEquals(10.0, mult(divd(lit(5.0), lit(2.0)), lit(4.0)).eval(), 0.0);

            Exp h1 = mult(lit(3.0), lit(2.0));
            Exp h2 = mult(h1, h1);
            Exp threeDeep = mult(h2, h2);

            Exp mult1 = mult(lit(5.0), threeDeep);
            mult1.truncate(1);
            Assert.assertEquals("(5.0*1296.0)", mult1.prettyp());

            Exp divd1 = divd(lit(5.0), threeDeep);
            divd1.truncate(1);
            Assert.assertEquals("(5.0/1296.0)", divd1.prettyp());

            Exp neg1 = neg(threeDeep);
            neg1.truncate(1);
            Assert.assertEquals("(-1296.0)", neg1.prettyp());

            Exp sub1 = sub(lit(5.0), threeDeep);
            sub1.truncate(1);
            Assert.assertEquals("(5.0-1296.0)", sub1.prettyp());

            Exp base = mult(add(lit(3.0), lit(7.0)), lit(3.0));
            String baseBeforeTrunc = base.prettyp();
            base.truncate(3);
            Assert.assertTrue("", base.prettyp().equals(baseBeforeTrunc));

            Exp larger = sub(base, divd(base, lit(1.0)));
            String largerBeforeTrunc = larger.prettyp();
            larger.truncate(4);
            Assert.assertTrue("", larger.prettyp().equals(largerBeforeTrunc));

            Exp nd1 = neg(lit(1.0));
            Exp nd2 = neg(nd1);
            Exp nd3 = neg(nd2);
            Assert.assertEquals("(-(-(-1.0)))", nd3.prettyp());
            nd3.truncate(2);

            // looks odd, but is right. The innermost one is the negation of -1.0
            Assert.assertEquals("(-(--1.0))", nd3.prettyp());

            larger.truncate(3);
            Exp baseTrunc = mult(lit(10.0), lit(3.0));
            Assert.assertEquals( base.prettyp(), baseTrunc.prettyp());
            Exp largerTrunc = sub(baseTrunc, divd(baseTrunc, lit(1.0)));
            Assert.assertEquals(larger.prettyp(), largerTrunc.prettyp());
        }

        default Lit lit(Double d) { return new trivially.ep.m4.finalized.Lit(d); }
        default Add add(Exp left, Exp right) { return new trivially.ep.m4.finalized.Add(left, right); }
        default Sub sub(Exp left, Exp right) { return new trivially.ep.m4.finalized.Sub(left, right); }
        default Mult mult(Exp left, Exp right) { return new trivially.ep.m4.finalized.Mult(left, right); }
        default Neg neg(Exp inner) { return new trivially.ep.m4.finalized.Neg(inner); }
        default Divd divd(Exp left, Exp right) { return new trivially.ep.m4.finalized.Divd(left, right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
