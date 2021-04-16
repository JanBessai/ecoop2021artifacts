package oo.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M3Test {

    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();

            Exp expr1 = new Mult(new Lit(3.0), new Lit(2.0));
            Assertions.assertEquals("(3.0*2.0)", expr1.prettyp());

            Exp expr2 = new Divd(new Lit(3.0), new Lit(2.0));
            Assertions.assertEquals("(3.0/2.0)", expr2.prettyp());

            Exp expr3 = new Neg(new Lit(3.0));
            Assertions.assertEquals("(-3.0)", expr3.prettyp());

            Exp expr4 = new Neg(expr1);
            Assertions.assertEquals("(-(3.0*2.0))", expr4.prettyp());

            Assertions.assertEquals(new Neg(new Lit(1.0)).eval(), -1.0, 0.0);
            Assertions.assertEquals("(-1.0)", new Neg(new Lit(1.0)).prettyp());
            Assertions.assertEquals("((5.0/2.0)*4.0)", new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).prettyp());
            Assertions.assertEquals(10.0, new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).eval(), 0.0);
            Assertions.assertEquals(new Neg(new Lit(5.0)).eval(), -5.0, 0.0);
            Assertions.assertEquals("(-(2.0*3.0))", new Neg(new Mult(new Lit(2.0), new Lit(3.0))).prettyp());
        }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
