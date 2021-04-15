package interpreter.ep;

import interpreter.ep.m7.PowByExp;
import org.junit.Assert;
import org.junit.Test;

public class M7Test extends M6Test {

    public interface TestTemplate extends M6Test.TestTemplate {
        default void test() {
            M6Test.TestTemplate.super.test();

            PowByExp pby = lit(3.0).powby(lit(2.0));
            PowByExp d1 = divd(lit(5.0), lit(2.0)).powby(lit(2.0));
            PowByExp m1 = mult(lit(5.0), lit(2.0)).powby(lit(2.0));
            PowByExp a1 = add(lit(5.0), lit(2.0)).powby(lit(2.0));
            PowByExp s1 = sub(lit(5.0), lit(3.0)).powby(lit(2.0));
            PowByExp n1 = neg(lit(5.0)).powby(lit(2.0));

            Assert.assertEquals(9.0, pby.eval(), 0.0);
            Assert.assertEquals(6.25, d1.eval(), 0.0);
            Assert.assertEquals(100.0, m1.eval(), 0.0);
            Assert.assertEquals(49.0, a1.eval(), 0.0);
            Assert.assertEquals(4.0, s1.eval(), 0.0);
            Assert.assertEquals(25.0, n1.eval(), 0.0);

            Assert.assertEquals(28561.0, add(lit(1.0), lit(12.0)).powby(lit(4.0)).eval(), 0.0);
        }
    }

    static PowByExp lit(Double d) { return new interpreter.ep.m7.PowByLit(d); }
    static PowByExp add(PowByExp left, PowByExp right) { return new interpreter.ep.m7.PowByAdd(left, right); }
    static PowByExp sub(PowByExp left, PowByExp right) { return new interpreter.ep.m7.PowBySub(left, right); }
    static PowByExp mult(PowByExp left, PowByExp right) { return new interpreter.ep.m7.PowByMult(left, right); }
    static PowByExp neg(PowByExp inner) { return new interpreter.ep.m7.PowByNeg(inner); }
    static PowByExp divd(PowByExp left, PowByExp right) { return new interpreter.ep.m7.PowByDivd(left, right); }

    private static class ActualTest implements M7Test.TestTemplate {}

    @Test
    public void testTest() { new M7Test.ActualTest().test(); }
}