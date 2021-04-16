package oo.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class I1Test {
    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();

            Assertions.assertEquals(-3.0, new Sub(new Lit(1.0), new Lit(2.0)).multby(new Lit(3.0)).eval(), 0.0);
            Assertions.assertEquals(-3.0, new Lit(3.0).multby_old(new Sub(new Lit(1.0), new Lit(2.0))).eval(), 0.0);

            Assertions.assertEquals(9.0, new Add(new Lit(1.0), new Lit(2.0)).multby(new Lit(3.0)).eval(), 0.0);
            Assertions.assertEquals(9.0, new Lit(3.0).multby_old(new Add(new Lit(1.0), new Lit(2.0))).eval(), 0.0);
        }
    }
    private static class ActualTest implements TestTemplate {}


    @Test
    public void testTest() { new ActualTest().test(); }
}
