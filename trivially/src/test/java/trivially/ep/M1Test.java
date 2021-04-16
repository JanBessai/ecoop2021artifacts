package trivially.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import trivially.ep.m0.Exp;

public class M1Test {

    public interface TestTemplate extends M0Test.TestTemplate {
        default void test() {
            M0Test.TestTemplate.super.test();

            Exp expr1 = sub(lit(1.0), lit(2.0));
            Assertions.assertEquals(-1.0, expr1.eval(), 0.0);

            Exp expr2 = lit(2.0);
            Assertions.assertEquals(2.0, expr2.eval(), 0.0);
            Assertions.assertEquals(sub(lit(1.0), lit(2.0)).eval(), -1.0, 0.0);
        }

        default Exp sub(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m1.finalized.Sub(left, right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
