package interpreter.ep;
import interpreter.ep.m0.EvalExp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M1Test {

   public interface TestTemplate extends M0Test.TestTemplate {

        default void test() {
            M0Test.TestTemplate.super.test();

            EvalExp expr1 = sub(lit(1.0), lit(2.0));
            Assertions.assertEquals(-1.0, expr1.eval(), 0.0);

            EvalExp expr2 = lit(2.0);
            Assertions.assertEquals(2.0, expr2.eval(), 0.0);
            Assertions.assertEquals(sub(lit(1.0), lit(2.0)).eval(), -1.0, 0.0);
        }

       default EvalExp sub(EvalExp left, EvalExp right) { return new interpreter.ep.m1.EvalSub(left, right); }
   }

    private static class ActualTest implements M1Test.TestTemplate {}

    @Test
    public void testTest() { new M1Test.ActualTest().test(); }
}
