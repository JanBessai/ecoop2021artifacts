package interpreter.ep;
import interpreter.ep.m0.EvalExp;
import interpreter.ep.m0.EvalExpFactory;
import interpreter.ep.m1.EvalSub;
import interpreter.ep.m1.EvalSubFactory;
import org.junit.Assert;
import org.junit.Test;

public class M1Test {

   public static class TestTemplate extends EvalSubFactory {

        void test() {
            EvalExp expr1 = sub(lit(1.0), lit(2.0));
            Assert.assertEquals(-1.0, expr1.eval(), 0.0);

            EvalExp expr2 = EvalExpFactory.lit(2.0);
            Assert.assertEquals(2.0, expr2.eval(), 0.0);
            Assert.assertEquals(sub(lit(1.0), lit(2.0)).eval(), -1.0, 0.0);
        }
    }

    @Test
    public void testTest() {
       new M0Test().testTest();
       new TestTemplate().test();
   }
}
