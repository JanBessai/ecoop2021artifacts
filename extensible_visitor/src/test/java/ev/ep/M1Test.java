package ev.ep;

import org.junit.Test;

public class M1Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(new Sub(new Lit(1.0), new Lit(2.0)).<Double>accept(this.makeEval())).equals(-1.0));
    }

    public EvalSub makeEval() {
        return new EvalSub();
    }
}
