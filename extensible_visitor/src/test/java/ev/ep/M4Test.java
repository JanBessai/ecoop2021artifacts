package ev.ep;

import java.util.List;
import org.junit.Test;

public class M4Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", new Divd(new Divd(new Lit(5.0), new Lit(7.0)), new Sub(new Lit(7.0), new Mult(new Lit(2.0), new Lit(3.0)))).<List<Double>>accept(this.makeCollect()).equals(java.util.Arrays.asList(5.0, 7.0, 7.0, 2.0, 3.0)));
        org.junit.Assert.assertTrue("", new Add(new Lit(0.0), new Lit(0.0)).<List<Double>>accept(this.makeCollect()).equals(java.util.Arrays.asList(0.0, 0.0)));
        org.junit.Assert.assertTrue("", new Neg(new Lit(0.0)).<List<Double>>accept(this.makeCollect()).equals(java.util.Arrays.asList(0.0)));
        org.junit.Assert.assertTrue("", new Mult(new Lit(1.0), new Lit(12.0)).<List<Double>>accept(this.makeCollect()).equals(java.util.Arrays.asList(1.0, 12.0)));
        org.junit.Assert.assertTrue("", new Mult(new Lit(13.0), new Lit(1.0)).<List<Double>>accept(this.makeCollect()).equals(java.util.Arrays.asList(13.0, 1.0)));
        org.junit.Assert.assertTrue("", new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).<String>accept(this.makePrettyp()).equals("((5.0/2.0)*4.0)"));
        org.junit.Assert.assertTrue("", Double.valueOf(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).<Double>accept(this.makeEval())).equals(10.0));
    }

    public EvalDivdMultNeg makeEval() {
        return new EvalDivdMultNeg();
    }

    public PrettypDivdMultNeg makePrettyp() {
        return new PrettypDivdMultNeg();
    }

    public Simplify makeSimplify() {
        return new Simplify();
    }

    public Collect makeCollect() {
        return new Collect();
    }
}
