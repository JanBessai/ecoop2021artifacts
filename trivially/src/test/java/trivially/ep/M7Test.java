package trivially.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

            Assertions.assertEquals(9.0, pby.eval(), 0.0);
            Assertions.assertEquals(6.25, d1.eval(), 0.0);
            Assertions.assertEquals(100.0, m1.eval(), 0.0);
            Assertions.assertEquals(49.0, a1.eval(), 0.0);
            Assertions.assertEquals(4.0, s1.eval(), 0.0);
            Assertions.assertEquals(25.0, n1.eval(), 0.0);

            Assertions.assertEquals(28561.0, add(lit(1.0), lit(12.0)).powby(lit(4.0)).eval(), 0.0);
        }

        @Override default Exp lit(Double d) { return new trivially.ep.m7.finalized.Lit(d); }
        @Override default Exp add(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m7.finalized.Add((Exp) left, (Exp) right); }
        @Override default Exp sub(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m7.finalized.Sub((Exp) left, (Exp) right); }
        @Override default Exp mult(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m7.finalized.Mult((Exp) left, (Exp) right); }
        @Override default Exp neg(trivially.ep.m0.Exp inner) { return new trivially.ep.m7.finalized.Neg((Exp) inner); }
        @Override default Exp divd(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m7.finalized.Divd((Exp) left, (Exp) right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
