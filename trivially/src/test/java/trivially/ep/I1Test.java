package trivially.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import trivially.ep.i1.*;

public class I1Test {
    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();

            Assertions.assertEquals(-3.0, sub(lit(1.0), lit(2.0)).multby(lit(3.0)).eval(), 0.0);

            Assertions.assertEquals(9.0, add(lit(1.0), lit(2.0)).multby(lit(3.0)).eval(), 0.0);
        }

        @Override default Exp lit(Double d) { return new trivially.ep.i1.finalized.Lit(d); }
        @Override default Exp add(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.i1.finalized.Add((Exp) left, (Exp) right); }
        @Override default Exp sub(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.i1.finalized.Sub((Exp) left, (Exp) right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
