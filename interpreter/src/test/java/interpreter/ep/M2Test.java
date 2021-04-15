package interpreter.ep;

import interpreter.ep.m2.PrettypExp;
import org.junit.Assert;
import org.junit.Test;

public class M2Test extends M1Test {

    public interface TestTemplate extends M1Test.TestTemplate {
        default void test() {
            M1Test.TestTemplate.super.test();

            PrettypExp expr1 = add(lit(1.0), lit(2.0));
            Assert.assertEquals("(1.0+2.0)", expr1.prettyp());

            PrettypExp expr2 = lit(2.0);
            Assert.assertEquals("2.0", expr2.prettyp());

            Assert.assertEquals("(1.0-2.0)", sub(lit(1.0), lit(2.0)).prettyp());
            Assert.assertEquals("((1.0-2.0)+(5.0+6.0))", add(sub(lit(1.0), lit(2.0)), add(lit(5.0), lit(6.0))).prettyp());
        }
    }

    static PrettypExp lit(Double d) { return new interpreter.ep.m2.PrettypLit(d); }
    static PrettypExp add(PrettypExp left, PrettypExp right) { return new interpreter.ep.m2.PrettypAdd(left, right); }
    static PrettypExp sub(PrettypExp left, PrettypExp right) { return new interpreter.ep.m2.PrettypSub(left, right); }

    private static class ActualTest implements M2Test.TestTemplate {}

    @Test
    public void testTest() { new M2Test.ActualTest().test(); }
}
