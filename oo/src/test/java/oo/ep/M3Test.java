package oo.ep;

import org.junit.Assert;
import org.junit.Test;

public class M3Test {

    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();

            Exp expr1 = new Mult(new Lit(3.0), new Lit(2.0));
            Assert.assertEquals("(3.0*2.0)", expr1.prettyp());

            Exp expr2 = new Divd(new Lit(3.0), new Lit(2.0));
            Assert.assertEquals("(3.0/2.0)", expr2.prettyp());

            Exp expr3 = new Neg(new Lit(3.0));
            Assert.assertEquals("(-3.0)", expr3.prettyp());

            Exp expr4 = new Neg(expr1);
            Assert.assertEquals("(-(3.0*2.0))", expr4.prettyp());

            Assert.assertEquals(new Neg(new Lit(1.0)).eval(), -1.0, 0.0);
            Assert.assertEquals("(-1.0)", new Neg(new Lit(1.0)).prettyp());
            Assert.assertEquals("((5.0/2.0)*4.0)", new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).prettyp());
            Assert.assertEquals(10.0, new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).eval(), 0.0);
            Assert.assertEquals(new Neg(new Lit(5.0)).eval(), -5.0, 0.0);
            Assert.assertEquals("(-(2.0*3.0))", new Neg(new Mult(new Lit(2.0), new Lit(3.0))).prettyp());
        }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
