package trivially.ep;

import org.junit.Assert;
import org.junit.Test;
import trivially.ep.m7.*;

public class M7Test {

    public interface TestTemplate extends M6Test.TestTemplate {
        default void test() {
            M6Test.TestTemplate.super.test();

            Exp pby = lit(3.0).powby(lit(2.0));
            Exp d1 = divd(lit(5.0), lit(2.0)).powby(lit(2.0));
            Exp m1 = mult(lit(5.0), lit(2.0)).powby(lit(2.0));
            Exp a1 = add(lit(5.0), lit(2.0)).powby(lit(2.0));
            Exp s1 = sub(lit(5.0), lit(3.0)).powby(lit(2.0));
            Exp n1 = neg(lit(5.0)).powby(lit(2.0));

            Assert.assertEquals(9.0, pby.eval(), 0.0);
            Assert.assertEquals(6.25, d1.eval(), 0.0);
            Assert.assertEquals(100.0, m1.eval(), 0.0);
            Assert.assertEquals(49.0, a1.eval(), 0.0);
            Assert.assertEquals(4.0, s1.eval(), 0.0);
            Assert.assertEquals(25.0, n1.eval(), 0.0);

            Assert.assertEquals(28561.0, add(lit(1.0), lit(12.0)).powby(lit(4.0)).eval(), 0.0);
        }

        default Lit lit(Double d) { return new trivially.ep.m7.finalized.Lit(d); }
        default Add add(Exp left, Exp right) { return new trivially.ep.m7.finalized.Add(left, right); }
        default Sub sub(Exp left, Exp right) { return new trivially.ep.m7.finalized.Sub(left, right); }
        default Mult mult(Exp left, Exp right) { return new trivially.ep.m7.finalized.Mult(left, right); }
        default Neg neg(Exp inner) { return new trivially.ep.m7.finalized.Neg(inner); }
        default Divd divd(Exp left, Exp right) { return new trivially.ep.m7.finalized.Divd(left, right); }
        
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
