package interpreter.ep;

import interpreter.ep.i1.MultByExp;
import org.junit.Assert;
import org.junit.Test;

public class I1Test extends M2Test {
    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();

            Assert.assertEquals(-3.0, (sub(lit(1.0), lit(2.0))).multby(lit(3.0)).eval(), 0.0);
            Assert.assertEquals(9.0, add(lit(1.0), lit(2.0)).multby(lit(3.0)).eval(), 0.0);
        }
    }

    static MultByExp lit(Double d) { return new interpreter.ep.i1.MultByLit(d); }
    static MultByExp add(MultByExp left, MultByExp right) { return new interpreter.ep.i1.MultByAdd(left, right); }
    static MultByExp sub(MultByExp left, MultByExp right) { return new interpreter.ep.i1.MultBySub(left, right); }

    private static class ActualTest implements I1Test.TestTemplate {}

    @Test
    public void testTest() { new I1Test.ActualTest().test(); }
}
