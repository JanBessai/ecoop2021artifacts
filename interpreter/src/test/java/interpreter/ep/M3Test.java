package interpreter.ep;

import interpreter.ep.m2.PrettypExp;
import org.junit.Assert;
import org.junit.Test;

public class M3Test extends M2Test {

    public interface TestTemplate extends M2Test.TestTemplate {
         default void test() {
            M2Test.TestTemplate.super.test();

            PrettypExp expr1 = mult(lit(3.0), lit(2.0));
            Assert.assertEquals("(3.0*2.0)", expr1.prettyp());

            PrettypExp expr2 = divd(lit(3.0), lit(2.0));
            Assert.assertEquals("(3.0/2.0)", expr2.prettyp());

            PrettypExp expr3 = neg(lit(3.0));
            Assert.assertEquals("(-3.0)", expr3.prettyp());

            PrettypExp expr4 = neg(expr1);
            Assert.assertEquals("(-(3.0*2.0))", expr4.prettyp());

            Assert.assertEquals(neg(lit(1.0)).eval(), -1.0, 0.0);
            Assert.assertEquals("(-1.0)", neg(lit(1.0)).prettyp());
            Assert.assertEquals("((5.0/2.0)*4.0)", mult(divd(lit(5.0), lit(2.0)), lit(4.0)).prettyp());
            Assert.assertEquals(10.0, mult(divd(lit(5.0), lit(2.0)), lit(4.0)).eval(), 0.0);
            Assert.assertEquals(neg(lit(5.0)).eval(), -5.0, 0.0);
            Assert.assertEquals("(-(2.0*3.0))", neg(mult(lit(2.0), lit(3.0))).prettyp());
        }
    }

    static PrettypExp mult(PrettypExp left, PrettypExp right) { return new interpreter.ep.m3.PrettypMult(left, right); }
    static PrettypExp neg(PrettypExp inner) { return new interpreter.ep.m3.PrettypNeg(inner); }
    static PrettypExp divd(PrettypExp left, PrettypExp right) { return new interpreter.ep.m3.PrettypDivd(left, right); }

    private static class ActualTest implements M3Test.TestTemplate {}

    @Test
    public void testTest() { new M3Test.ActualTest().test(); }
}
