package ev.ep;

import ev.ep.m0.Lit;
import ev.ep.m1.EvalSub;
import ev.ep.m1.Sub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M1Test extends M0Test {

    public interface TestTemplate extends M0Test.TestTemplate {
        default void test() {
            M0Test.TestTemplate.super.test();

            Sub expr1 = new Sub(new Lit(1.0), new Lit(2.0));
            Assertions.assertEquals(-1.0, expr1.<Double>accept(makeEval()), 0.0);

            Lit expr2 = new Lit(2.0);
            Assertions.assertEquals(2.0, expr2.<Double>accept(makeEval()), 0.0);
            Assertions.assertEquals(new Sub(new Lit(1.0), new Lit(2.0)).<Double>accept(makeEval()), -1.0, 0.0);
        }

        default Visitor<Double> makeEval() {
            return new EvalSub();
        }
    }

    private static class ActualTest implements M1Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
