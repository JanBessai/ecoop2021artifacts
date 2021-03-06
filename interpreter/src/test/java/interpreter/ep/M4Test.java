package interpreter.ep;

import interpreter.ep.m0.EvalExp;
import interpreter.ep.m2.PrettypExp;
import interpreter.ep.m4.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class M4Test {
    public interface TestTemplate extends M3Test.TestTemplate {
        default void test() {
            M3Test.TestTemplate.super.test();

            CollectSimplifyExp expr1 = divd(lit(3.0), lit(1.0));
            Assertions.assertEquals("3.0", expr1.simplify().prettyp());

            CollectSimplifyExp expr2 = divd(lit(0.0), lit(2.0));
            Assertions.assertEquals("0.0", expr2.simplify().prettyp());

            CollectSimplifyExp expr3 = divd(lit(3.0), divd(lit(6.0), lit(2.0)));
            Assertions.assertEquals("1.0", expr3.simplify().prettyp());

            CollectSimplifyExp expr4 = neg(expr1);
            Assertions.assertEquals("(-3.0)", expr4.simplify().prettyp());

            CollectSimplifyExp expr6 = add(lit(-2.0), lit(2.0));
            Assertions.assertEquals("0.0", expr6.simplify().prettyp());

            CollectSimplifyExp expr7 = add(lit(-2.0), lit(0.0));
            Assertions.assertEquals("-2.0", expr7.simplify().prettyp());

            CollectSimplifyExp expr8 = add(lit(-2.0), lit(-5.0));
            Assertions.assertEquals("(-2.0+-5.0)", expr8.simplify().prettyp());

            CollectSimplifyExp sub2 = sub(lit(3.0), lit(3.0));
            Assertions.assertEquals("0.0", sub2.simplify().prettyp());

            CollectSimplifyExp neg2 = neg(lit(0.0));
            Assertions.assertEquals("0.0", neg2.simplify().prettyp());

            CollectSimplifyExp left = mult(lit(3.0), lit(1.0));
            CollectSimplifyExp right = mult(lit(1.0), lit(9.0));
            CollectSimplifyExp expr5 = divd(left, right);
            Assertions.assertEquals("(3.0/9.0)", expr5.simplify().prettyp());

            Assertions.assertEquals(divd(divd(lit(5.0), lit(7.0)), sub(lit(7.0), mult(lit(2.0), lit(3.0)))).collect(), Arrays.asList(5.0, 7.0, 7.0, 2.0, 3.0));
            Assertions.assertEquals(add(lit(0.0), lit(0.0)).collect(), Arrays.asList(0.0, 0.0));
            Assertions.assertEquals(neg(lit(0.0)).collect(), Collections.singletonList(0.0));
            Assertions.assertEquals(mult(lit(1.0), lit(12.0)).collect(), Arrays.asList(1.0, 12.0));
            Assertions.assertEquals(mult(lit(13.0), lit(1.0)).collect(), Arrays.asList(13.0, 1.0));
            Assertions.assertEquals("((5.0/2.0)*4.0)", mult(divd(lit(5.0), lit(2.0)), lit(4.0)).prettyp());
            Assertions.assertEquals(10.0, mult(divd(lit(5.0), lit(2.0)), lit(4.0)).eval(), 0.0);

            CollectSimplifyExp h1 = mult(lit(3.0), lit(2.0));
            CollectSimplifyExp h2 = mult(h1, h1);
            CollectSimplifyExp threeDeep = mult(h2, h2);

            CollectSimplifyExp mult1 = mult(lit(5.0), threeDeep);
            mult1.truncate(1);
            Assertions.assertEquals("(5.0*1296.0)", mult1.prettyp());

            CollectSimplifyExp divd1 = divd(lit(5.0), threeDeep);
            divd1.truncate(1);
            Assertions.assertEquals("(5.0/1296.0)", divd1.prettyp());

            CollectSimplifyExp neg1 = neg(threeDeep);
            neg1.truncate(1);
            Assertions.assertEquals("(-1296.0)", neg1.prettyp());

            CollectSimplifyExp sub1 = sub(lit(5.0), threeDeep);
            sub1.truncate(1);
            Assertions.assertEquals("(5.0-1296.0)", sub1.prettyp());

            CollectSimplifyExp base = mult(add(lit(3.0), lit(7.0)), lit(3.0));
            String baseBeforeTrunc = base.prettyp();
            base.truncate(3);
            Assertions.assertTrue(base.prettyp().equals(baseBeforeTrunc));

            CollectSimplifyExp larger = sub(base, divd(base, lit(1.0)));
            String largerBeforeTrunc = larger.prettyp();
            larger.truncate(4);
            Assertions.assertTrue(larger.prettyp().equals(largerBeforeTrunc));

            CollectSimplifyExp nd1 = neg(lit(1.0));
            CollectSimplifyExp nd2 = neg(nd1);
            CollectSimplifyExp nd3 = neg(nd2);
            Assertions.assertEquals("(-(-(-1.0)))", nd3.prettyp());
            nd3.truncate(2);

            // looks odd, but is right. The innermost one is the negation of -1.0
            Assertions.assertEquals("(-(--1.0))", nd3.prettyp());

            larger.truncate(3);
            CollectSimplifyExp baseTrunc = mult(lit(10.0), lit(3.0));
            Assertions.assertEquals( base.prettyp(), baseTrunc.prettyp());
            CollectSimplifyExp largerTrunc = sub(baseTrunc, divd(baseTrunc, lit(1.0)));
            Assertions.assertEquals(larger.prettyp(), largerTrunc.prettyp());
        }

        @Override default CollectSimplifyExp lit(Double d) { return new interpreter.ep.m4.CollectSimplifyLit(d); }
        @Override default CollectSimplifyExp add(EvalExp left, EvalExp right) { return new interpreter.ep.m4.CollectSimplifyAdd((CollectSimplifyExp) left, (CollectSimplifyExp) right); }
        @Override default CollectSimplifyExp sub(EvalExp left, EvalExp right) { return new interpreter.ep.m4.CollectSimplifySub((CollectSimplifyExp) left, (CollectSimplifyExp) right); }
        @Override default CollectSimplifyExp mult(PrettypExp left, PrettypExp right) { return new interpreter.ep.m4.CollectSimplifyMult((CollectSimplifyExp) left, (CollectSimplifyExp) right); }
        @Override default CollectSimplifyExp neg(PrettypExp inner) { return new interpreter.ep.m4.CollectSimplifyNeg((CollectSimplifyExp) inner); }
        @Override default CollectSimplifyExp divd(PrettypExp left, PrettypExp right) { return new interpreter.ep.m4.CollectSimplifyDivd((CollectSimplifyExp) left, (CollectSimplifyExp) right); }
    }

    private static class ActualTest implements M4Test.TestTemplate {}

    @Test
    public void testTest() { new M4Test.ActualTest().test(); }
}
