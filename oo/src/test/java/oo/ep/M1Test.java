package oo.ep;
import org.junit.Assert;
import org.junit.Test;

public class M1Test {

    public interface TestTemplate extends M0Test.TestTemplate {
        default void test() {
            M0Test.TestTemplate.super.test();

            Exp expr1 = new Sub(new Lit(1.0), new Lit(2.0));
            Assert.assertEquals(-1.0, expr1.eval(), 0.0);

            Exp expr2 = new Lit(2.0);
            Assert.assertEquals(2.0, expr2.eval(), 0.0);
            Assert.assertEquals(new Sub(new Lit(1.0), new Lit(2.0)).eval(), -1.0, 0.0);
        }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
