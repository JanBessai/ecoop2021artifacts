package oo.ep;

import org.junit.Assert;
import org.junit.Test;

public class M2Test {

    public interface TestTemplate extends M1Test.TestTemplate {
        default void test() {
            M1Test.TestTemplate.super.test();

            Exp expr1 = new Add(new Lit(1.0), new Lit(2.0));
            Assert.assertEquals("(1.0+2.0)", expr1.prettyp());

            Exp expr2 = new Lit(2.0);
            Assert.assertEquals("2.0", expr2.prettyp());

            Assert.assertEquals("(1.0-2.0)", new Sub(new Lit(1.0), new Lit(2.0)).prettyp());
            Assert.assertEquals("((1.0-2.0)+(5.0+6.0))", new Add(new Sub(new Lit(1.0), new Lit(2.0)), new Add(new Lit(5.0), new Lit(6.0))).prettyp());
        }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
