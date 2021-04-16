package ev.ep;

import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.EvalSub;
import ev.ep.m1.Sub;
import ev.ep.m2.Prettyp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M2Test {

    public interface TestTemplate extends M1Test.TestTemplate {
        default void test() {
            M1Test.TestTemplate.super.test();
            Add expr1 = new Add(new Lit(1.0), new Lit(2.0));
            
            Assertions.assertEquals("(1.0+2.0)", expr1.accept(makePrettyp()));

            Lit expr2 = new Lit(2.0);
            Assertions.assertEquals("2.0", expr2.accept(makePrettyp()));

            Assertions.assertEquals("(1.0-2.0)", new Sub(new Lit(1.0), new Lit(2.0)).accept(makePrettyp()));
            Assertions.assertEquals("((1.0-2.0)+(5.0+6.0))", new Add(new Sub(new Lit(1.0), new Lit(2.0)), new Add(new Lit(5.0), new Lit(6.0))).accept(makePrettyp()));
        }

        default Visitor<Double> makeEval() {
            return new EvalSub();
        }
        default Visitor<String> makePrettyp() {
            return new Prettyp();
        }
    }

    private static class ActualTest implements M2Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
