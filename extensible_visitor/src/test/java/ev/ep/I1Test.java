package ev.ep;

import ev.ep.i1.MultBy;
import ev.ep.m1.EvalSub;
import ev.ep.m0.Lit;
import ev.ep.m0.Add;
import ev.ep.m1.Sub;
import ev.ep.m1.VisitorSub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class I1Test extends M0Test {

    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();

            Assertions.assertEquals(-3.0, new Sub(new Lit(1.0), new Lit(2.0)).accept(makeMultBy(new Lit(3.0))).accept(makeEval()), 0.0);
            Assertions.assertEquals(9.0, new Add(new Lit(1.0), new Lit(2.0)).accept(makeMultBy(new Lit(3.0))).accept(makeEval()), 0.0);
        }

        default VisitorSub<Double> makeEval() { return new EvalSub();}
        default VisitorSub<Exp> makeMultBy (Exp other) {
            return new MultBy(other);
        }
    }

    private static class ActualTest implements I1Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
