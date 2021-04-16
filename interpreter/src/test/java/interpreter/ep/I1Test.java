package interpreter.ep;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.m0.EvalExp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class I1Test {
    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();

            Assertions.assertEquals(-3.0, (sub(lit(1.0), lit(2.0))).multby(lit(3.0)).eval(), 0.0);
            Assertions.assertEquals(9.0, add(lit(1.0), lit(2.0)).multby(lit(3.0)).eval(), 0.0);
        }

        @Override default MultByExp lit(Double d) { return new interpreter.ep.i1.MultByLit(d); }
        @Override default MultByExp add(EvalExp left, EvalExp right) { return new interpreter.ep.i1.MultByAdd((MultByExp) left, (MultByExp) right); }
        @Override default MultByExp sub(EvalExp left, EvalExp right) { return new interpreter.ep.i1.MultBySub((MultByExp) left, (MultByExp) right); }
    }

    private static class ActualTest implements I1Test.TestTemplate {}

    @Test
    public void testTest() { new I1Test.ActualTest().test(); }
}
