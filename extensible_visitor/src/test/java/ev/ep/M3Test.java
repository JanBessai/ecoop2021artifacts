package ev.ep;

import ev.ep.m0.Lit;
import ev.ep.m3.*;
import org.junit.Assert;
import org.junit.Test;

public class M3Test {

    public interface TestTemplate extends M2Test.TestTemplate {
        default void test() {
            M2Test.TestTemplate.super.test();
            Mult expr1 = new Mult(new Lit(3.0), new Lit(2.0));
            Assert.assertEquals("(3.0*2.0)", expr1.accept(this.makePrettyp()));

            Divd expr2 = new Divd(new Lit(3.0), new Lit(2.0));
            Assert.assertEquals("(3.0/2.0)", expr2.accept(this.makePrettyp()));

            Neg expr3 = new Neg(new Lit(3.0));
            Assert.assertEquals("(-3.0)", expr3.accept(this.makePrettyp()));

            Neg expr4 = new Neg(expr1);
            Assert.assertEquals("(-(3.0*2.0))", expr4.accept(this.makePrettyp()));

            Assert.assertEquals(new Neg(new Lit(1.0)).accept(this.makeEval()), -1.0, 0.0);
            Assert.assertEquals("(-1.0)", new Neg(new Lit(1.0)).accept(this.makePrettyp()));
            Assert.assertEquals("((5.0/2.0)*4.0)", new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(this.makePrettyp()));
            Assert.assertEquals(10.0, new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(this.makeEval()), 0.0);
            Assert.assertEquals(new Neg(new Lit(5.0)).accept(this.makeEval()), -5.0, 0.0);
            Assert.assertEquals("(-(2.0*3.0))", new Neg(new Mult(new Lit(2.0), new Lit(3.0))).accept(this.makePrettyp()));
        }

        default EvalDivdMultNeg makeEval() { return new EvalDivdMultNeg(); }

        default PrettypDivdMultNeg makePrettyp() { return new PrettypDivdMultNeg(); }
    }
    private static class ActualTest implements M3Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
