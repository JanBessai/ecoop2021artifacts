package interpreter.ep;

import interpreter.ep.i1.MultByExpFactory;
import org.junit.Assert;
import org.junit.Test;

public class I1Test  {
    public static class TestTemplate extends MultByExpFactory {
        void test() {

            Assert.assertEquals(-3.0, sub(lit(1.0), lit(2.0)).multby(lit(3.0)).eval(), 0.0);
            Assert.assertEquals(9.0, add(lit(1.0), lit(2.0)).multby(lit(3.0)).eval(), 0.0);
        }
    }

    @Test
    public void testTest() {
        new M1Test().testTest();
        new TestTemplate().test();
    }
}
