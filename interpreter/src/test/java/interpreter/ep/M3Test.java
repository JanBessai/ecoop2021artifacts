package interpreter.ep;

import interpreter.ep.m2.PrettypExp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M3Test {

    public interface TestTemplate extends M2Test.TestTemplate {
         default void test() {
            M2Test.TestTemplate.super.test();

            PrettypExp expr1 = mult(lit(3.0), lit(2.0));
            Assertions.assertEquals("(3.0*2.0)", expr1.prettyp());

            PrettypExp expr2 = divd(lit(3.0), lit(2.0));
            Assertions.assertEquals("(3.0/2.0)", expr2.prettyp());

            PrettypExp expr3 = neg(lit(3.0));
            Assertions.assertEquals("(-3.0)", expr3.prettyp());

            PrettypExp expr4 = neg(expr1);
            Assertions.assertEquals("(-(3.0*2.0))", expr4.prettyp());

            Assertions.assertEquals(neg(lit(1.0)).eval(), -1.0, 0.0);
            Assertions.assertEquals("(-1.0)", neg(lit(1.0)).prettyp());
            Assertions.assertEquals("((5.0/2.0)*4.0)", mult(divd(lit(5.0), lit(2.0)), lit(4.0)).prettyp());
            Assertions.assertEquals(10.0, mult(divd(lit(5.0), lit(2.0)), lit(4.0)).eval(), 0.0);
            Assertions.assertEquals(neg(lit(5.0)).eval(), -5.0, 0.0);
            Assertions.assertEquals("(-(2.0*3.0))", neg(mult(lit(2.0), lit(3.0))).prettyp());
        }

        default PrettypExp mult(PrettypExp left, PrettypExp right) { return new interpreter.ep.m3.PrettypMult(left, right); }
        default PrettypExp neg(PrettypExp inner) { return new interpreter.ep.m3.PrettypNeg(inner); }
        default PrettypExp divd(PrettypExp left, PrettypExp right) { return new interpreter.ep.m3.PrettypDivd(left, right); }
    }

    private static class ActualTest implements M3Test.TestTemplate {}

    @Test
    public void testTest() { new M3Test.ActualTest().test(); }
}
