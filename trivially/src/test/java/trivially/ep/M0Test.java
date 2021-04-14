package trivially.ep;

import org.junit.Assert;
import org.junit.Test;
import trivially.ep.m0.Add;
import trivially.ep.m0.Exp;
import trivially.ep.m0.Lit;

public class M0Test {
    public interface TestTemplate  {
        default void test() {
            Exp expr1 = add(lit(1.0), lit(2.0));
            Assert.assertEquals(3.0, expr1.eval(), 0.0);

            Exp expr2 = lit(2.0);
            Assert.assertEquals(2.0, expr2.eval(), 0.0);

            Assert.assertEquals(3.0, add(lit(1.0), lit(2.0)).eval(), 0.0);
            Assert.assertEquals(5.0, lit(5.0).eval(), 0.0);
        }
        
        default Lit lit(Double d) { return new trivially.ep.m0.finalized.Lit(d); }
        default Add add(Exp left, Exp right) { return new trivially.ep.m0.finalized.Add(left, right); }
    }

    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
