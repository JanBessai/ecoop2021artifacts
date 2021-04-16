package oo.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class M4Test {
    public interface TestTemplate extends M3Test.TestTemplate {
        default void test() {
            M3Test.TestTemplate.super.test();

            Exp expr1 = new Divd(new Lit(3.0), new Lit(1.0));
            Assertions.assertEquals("3.0", expr1.simplify().prettyp());

            Exp expr2 = new Divd(new Lit(0.0), new Lit(2.0));
            Assertions.assertEquals("0.0", expr2.simplify().prettyp());

            Exp expr3 = new Divd(new Lit(3.0), new Divd(new Lit(6.0), new Lit(2.0)));
            Assertions.assertEquals("1.0", expr3.simplify().prettyp());

            Exp expr4 = new Neg(expr1);
            Assertions.assertEquals("(-3.0)", expr4.simplify().prettyp());

            Exp expr6 = new Add(new Lit(-2.0), new Lit(2.0));
            Assertions.assertEquals("0.0", expr6.simplify().prettyp());

            Exp expr7 = new Add(new Lit(-2.0), new Lit(0.0));
            Assertions.assertEquals("-2.0", expr7.simplify().prettyp());

            Exp expr8 = new Add(new Lit(-2.0), new Lit(-5.0));
            Assertions.assertEquals("(-2.0+-5.0)", expr8.simplify().prettyp());

            Exp sub2 = new Sub(new Lit(3.0), new Lit(3.0));
            Assertions.assertEquals("0.0", sub2.simplify().prettyp());

            Exp neg2 = new Neg(new Lit(0.0));
            Assertions.assertEquals("0.0", neg2.simplify().prettyp());

            Exp left = new Mult(new Lit(3.0), new Lit(1.0));
            Exp right = new Mult(new Lit(1.0), new Lit(9.0));
            Exp expr5 = new Divd(left, right);
            Assertions.assertEquals("(3.0/9.0)", expr5.simplify().prettyp());

            Assertions.assertEquals(new Divd(new Divd(new Lit(5.0), new Lit(7.0)), new Sub(new Lit(7.0), new Mult(new Lit(2.0), new Lit(3.0)))).collect(), Arrays.asList(5.0, 7.0, 7.0, 2.0, 3.0));
            Assertions.assertEquals(new Add(new Lit(0.0), new Lit(0.0)).collect(), Arrays.asList(0.0, 0.0));
            Assertions.assertEquals(new Neg(new Lit(0.0)).collect(), Collections.singletonList(0.0));
            Assertions.assertEquals(new Mult(new Lit(1.0), new Lit(12.0)).collect(), Arrays.asList(1.0, 12.0));
            Assertions.assertEquals(new Mult(new Lit(13.0), new Lit(1.0)).collect(), Arrays.asList(13.0, 1.0));
            Assertions.assertEquals("((5.0/2.0)*4.0)", new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).prettyp());
            Assertions.assertEquals(10.0, new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).eval(), 0.0);

            Exp h1 = new Mult(new Lit(3.0), new Lit(2.0));
            Exp h2 = new Mult(h1, h1);
            Exp threeDeep = new Mult(h2, h2);

            Exp mult1 = new Mult(new Lit(5.0), threeDeep);
            mult1.truncate(1);
            Assertions.assertEquals("(5.0*1296.0)", mult1.prettyp());

            Exp divd1 = new Divd(new Lit(5.0), threeDeep);
            divd1.truncate(1);
            Assertions.assertEquals("(5.0/1296.0)", divd1.prettyp());

            Exp neg1 = new Neg(threeDeep);
            neg1.truncate(1);
            Assertions.assertEquals("(-1296.0)", neg1.prettyp());

            Exp sub1 = new Sub(new Lit(5.0), threeDeep);
            sub1.truncate(1);
            Assertions.assertEquals("(5.0-1296.0)", sub1.prettyp());

            Exp base = new Mult(new Add(new Lit(3.0), new Lit(7.0)), new Lit(3.0));
            String baseBeforeTrunc = base.prettyp();
            base.truncate(3);
            Assertions.assertEquals(baseBeforeTrunc, base.prettyp());

            Exp larger = new Sub(base, new Divd(base, new Lit(1.0)));
            String largerBeforeTrunc = larger.prettyp();
            larger.truncate(4);
            Assertions.assertEquals(largerBeforeTrunc, larger.prettyp());

            Exp nd1 = new Neg(new Lit(1.0));
            Exp nd2 = new Neg(nd1);
            Exp nd3 = new Neg(nd2);
            Assertions.assertEquals("(-(-(-1.0)))", nd3.prettyp());
            nd3.truncate(2);

            // looks odd, but is right. The innermost one is the negation of -1.0
            Assertions.assertEquals("(-(--1.0))", nd3.prettyp());

            larger.truncate(3);
            Exp baseTrunc = new Mult(new Lit(10.0), new Lit(3.0));
            Assertions.assertEquals( base.prettyp(), baseTrunc.prettyp());
            Exp largerTrunc = new Sub(baseTrunc, new Divd(baseTrunc, new Lit(1.0)));
            Assertions.assertEquals(larger.prettyp(), largerTrunc.prettyp());
        }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
