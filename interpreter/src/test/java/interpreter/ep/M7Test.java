package interpreter.ep;

import interpreter.ep.m0.EvalExp;
import interpreter.ep.m2.PrettypExp;
import interpreter.ep.m7.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M7Test {

    public interface TestTemplate extends M6Test.TestTemplate {
        default void test() {
            M6Test.TestTemplate.super.test();

            PowByExp pby = lit(3.0).powby(lit(2.0));
            PowByExp d1 = divd(lit(5.0), lit(2.0)).powby(lit(2.0));
            PowByExp m1 = mult(lit(5.0), lit(2.0)).powby(lit(2.0));
            PowByExp a1 = add(lit(5.0), lit(2.0)).powby(lit(2.0));
            PowByExp s1 = sub(lit(5.0), lit(3.0)).powby(lit(2.0));
            PowByExp n1 = neg(lit(5.0)).powby(lit(2.0));

            Assertions.assertEquals(9.0, pby.eval(), 0.0);
            Assertions.assertEquals(6.25, d1.eval(), 0.0);
            Assertions.assertEquals(100.0, m1.eval(), 0.0);
            Assertions.assertEquals(49.0, a1.eval(), 0.0);
            Assertions.assertEquals(4.0, s1.eval(), 0.0);
            Assertions.assertEquals(25.0, n1.eval(), 0.0);

            Assertions.assertEquals(28561.0, add(lit(1.0), lit(12.0)).powby(lit(4.0)).eval(), 0.0);
        }

        @Override default PowByExp lit(Double d) { return new interpreter.ep.m7.PowByLit(d); }
        @Override default PowByExp add(EvalExp left, EvalExp right) { return new interpreter.ep.m7.PowByAdd((PowByExp) left, (PowByExp) right); }
        @Override default PowByExp sub(EvalExp left, EvalExp right) { return new interpreter.ep.m7.PowBySub((PowByExp) left, (PowByExp) right); }
        @Override default PowByExp mult(PrettypExp left, PrettypExp right) { return new interpreter.ep.m7.PowByMult((PowByExp) left, (PowByExp) right); }
        @Override default PowByExp neg(PrettypExp inner) { return new interpreter.ep.m7.PowByNeg((PowByExp) inner); }
        @Override default PowByExp divd(PrettypExp left, PrettypExp right) { return new interpreter.ep.m7.PowByDivd((PowByExp) left, (PowByExp) right); }
    }
    private static class ActualTest implements M7Test.TestTemplate {}

    @Test
    public void testTest() { new M7Test.ActualTest().test(); }
}