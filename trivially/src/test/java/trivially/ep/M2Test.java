package trivially.ep;

import org.junit.Assert;
import org.junit.Test;
import trivially.ep.m2.Exp;

import trivially.ep.m2.Add;
import trivially.ep.m2.Lit;
import trivially.ep.m2.Sub;

public class M2Test {

    public interface TestTemplate extends M1Test.TestTemplate {
        default void test() {
            M1Test.TestTemplate.super.test();

            Exp expr1 = add(lit(1.0), lit(2.0));
            Assert.assertEquals("(1.0+2.0)", expr1.prettyp());

            Exp expr2 = lit(2.0);
            Assert.assertEquals("2.0", expr2.prettyp());

            Assert.assertEquals("(1.0-2.0)", sub(lit(1.0), lit(2.0)).prettyp());
            Assert.assertEquals("((1.0-2.0)+(5.0+6.0))", add(sub(lit(1.0), lit(2.0)), add(lit(5.0), lit(6.0))).prettyp());
        }

        @Override default Exp lit(Double d) { return new trivially.ep.m2.finalized.Lit(d); }
        @Override default Exp add(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m2.finalized.Add((Exp) left, (Exp) right); }
        @Override default Exp sub(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m2.finalized.Sub((Exp) left, (Exp) right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
