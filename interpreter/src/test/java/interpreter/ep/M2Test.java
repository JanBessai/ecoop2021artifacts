package interpreter.ep;

import interpreter.ep.m2.PrettypExpFactory;
import interpreter.ep.m2.PrettypExp;
import org.junit.Assert;
import org.junit.Test;

public class M2Test {

    public static class TestTemplate extends PrettypExpFactory {
        void test() {

            PrettypExp expr1 = add(lit(1.0), lit(2.0));
            Assert.assertEquals("(1.0+2.0)", expr1.prettyp());

            PrettypExp expr2 = lit(2.0);
            Assert.assertEquals("2.0", expr2.prettyp());

            Assert.assertEquals("(1.0-2.0)", sub(lit(1.0), lit(2.0)).prettyp());
            Assert.assertEquals("((1.0-2.0)+(5.0+6.0))", add(sub(lit(1.0), lit(2.0)), add(lit(5.0), lit(6.0))).prettyp());
        }
    }

    @Test
    public void testTest() {
        new M1Test().testTest();
        new TestTemplate().test();
    }
}
