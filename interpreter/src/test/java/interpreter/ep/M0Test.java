package interpreter.ep;

import interpreter.ep.m0.EvalExp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M0Test {
    public interface TestTemplate {
        default void test() {
            EvalExp expr1 = add(lit(1.0), lit(2.0));
            Assertions.assertEquals(3.0, expr1.eval(), 0.0);

            EvalExp expr2 = lit(2.0);
            Assertions.assertEquals(2.0, expr2.eval(), 0.0);

            Assertions.assertEquals(3.0, add(lit(1.0), lit(2.0)).eval(), 0.0);
            Assertions.assertEquals(5.0, lit(5.0).eval(), 0.0);
        }

        default EvalExp lit(Double d) { return new interpreter.ep.m0.EvalLit(d); }
        default EvalExp add(EvalExp left, EvalExp right) { return new interpreter.ep.m0.EvalAdd(left, right); }
    }

    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
