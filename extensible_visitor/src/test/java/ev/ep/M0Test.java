package ev.ep;

import ev.ep.m0.Add;
import ev.ep.m0.Eval;
import ev.ep.m0.Lit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M0Test {
    public interface TestTemplate {

        default void test() {
            Add expr1 = new Add(new Lit(1.0), new Lit(2.0));
            Assertions.assertEquals(3.0, expr1.<Double>accept(makeEval()), 0.0);

            Lit expr2 = new Lit(2.0);
            Assertions.assertEquals(2.0, expr2.<Double>accept(makeEval()), 0.0);

            Assertions.assertEquals(3.0, new Add(new Lit(1.0), new Lit(2.0)).<Double>accept(makeEval()), 0.0);
            Assertions.assertEquals(5.0, new Lit(5.0).<Double>accept(makeEval()), 0.0);

            Assertions.assertEquals(3.0, new Add(new Lit(1.0), new Lit(2.0)).<Double>accept(makeEval()), 0.0);
            Assertions.assertEquals(5.0, new Lit(5.0).<Double>accept(makeEval()), 0.0);
        }

        default Visitor<Double> makeEval() {
            return new Eval();
        }
    }

    @Test
    public void testTest() { new TestTemplate(){}.test(); }
}
