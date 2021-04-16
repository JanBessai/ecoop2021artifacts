package trivially.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import trivially.ep.m0.Exp;

public class M0Test {
    public interface TestTemplate  {
        default void test() {
            Exp expr1 = add(lit(1.0), lit(2.0));
            Assertions.assertEquals(3.0, expr1.eval(), 0.0);

            Exp expr2 = lit(2.0);
            Assertions.assertEquals(2.0, expr2.eval(), 0.0);

            Assertions.assertEquals(3.0, add(lit(1.0), lit(2.0)).eval(), 0.0);
            Assertions.assertEquals(5.0, lit(5.0).eval(), 0.0);
        }
        
        default Exp lit(Double d) { return new trivially.ep.m0.finalized.Lit(d); }
        default Exp add(Exp left, Exp right) { return new trivially.ep.m0.finalized.Add(left, right); }
    }

    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
