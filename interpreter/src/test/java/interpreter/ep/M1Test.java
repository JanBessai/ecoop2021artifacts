package interpreter.ep;
import interpreter.ep.m0.EvalExp;
import interpreter.ep.m1.EvalSub;
import org.junit.Assert;
import org.junit.Test;

public class M1Test extends M0Test {

   public interface TestTemplate extends M0Test.TestTemplate {

        default void test() {
            M0Test.TestTemplate.super.test();

            EvalExp expr1 = sub(lit(1.0), lit(2.0));
            Assert.assertEquals(-1.0, expr1.eval(), 0.0);

            EvalExp expr2 = lit(2.0);
            Assert.assertEquals(2.0, expr2.eval(), 0.0);
            Assert.assertEquals(sub(lit(1.0), lit(2.0)).eval(), -1.0, 0.0);
        }
   }

    static EvalSub sub(EvalExp left, EvalExp right) { return new interpreter.ep.m1.EvalSub(left, right); }

    private static class ActualTest implements M1Test.TestTemplate {}

    @Test
    public void testTest() { new M1Test.ActualTest().test(); }
}
