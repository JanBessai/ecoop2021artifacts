package trivially.ep;

import org.junit.Assert;
import org.junit.Test;
import trivially.ep.i1.*;

public class I1Test {
    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();

            Assert.assertEquals(-3.0, sub(lit(1.0), lit(2.0)).multby(lit(3.0)).eval(), 0.0);

            Assert.assertEquals(9.0, add(lit(1.0), lit(2.0)).multby(lit(3.0)).eval(), 0.0);
        }

        default Lit lit(Double d) { return new trivially.ep.i1.finalized.Lit(d); }
        default Add add(Exp left, Exp right) { return new trivially.ep.i1.finalized.Add(left, right); }
        default Sub sub(Exp left, Exp right) { return new trivially.ep.i1.finalized.Sub(left, right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
