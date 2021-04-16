package trivially.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import trivially.ep.m2.Exp;

public class M3Test {

    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();

            Exp expr1 = mult(lit(3.0), lit(2.0));
            Assertions.assertEquals("(3.0*2.0)", expr1.prettyp());

            Exp expr2 = divd(lit(3.0), lit(2.0));
            Assertions.assertEquals("(3.0/2.0)", expr2.prettyp());

            Exp expr3 = neg(lit(3.0));
            Assertions.assertEquals("(-3.0)", expr3.prettyp());

            Exp expr4 = neg(expr1);
            Assertions.assertEquals("(-(3.0*2.0))", expr4.prettyp());

            Assertions.assertEquals(neg(lit(1.0)).eval(), -1.0, 0.0);
            Assertions.assertEquals("(-1.0)", neg(lit(1.0)).prettyp());
            Assertions.assertEquals("((5.0/2.0)*4.0)", mult(divd(lit(5.0), lit(2.0)), lit(4.0)).prettyp());
            Assertions.assertEquals(10.0, mult(divd(lit(5.0), lit(2.0)), lit(4.0)).eval(), 0.0);
            Assertions.assertEquals(neg(lit(5.0)).eval(), -5.0, 0.0);
            Assertions.assertEquals("(-(2.0*3.0))", neg(mult(lit(2.0), lit(3.0))).prettyp());
        }

        default Exp mult(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m3.finalized.Mult((Exp) left, (Exp) right); }
        default Exp neg(trivially.ep.m0.Exp inner) { return new trivially.ep.m3.finalized.Neg((Exp) inner); }
        default Exp divd(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m3.finalized.Divd((Exp) left, (Exp) right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
