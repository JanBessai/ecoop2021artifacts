package ev.ep;

import org.junit.Test;

public class M0Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(new Add(new Lit(1.0), new Lit(2.0)).<Double>accept(this.makeEval())).equals(3.0));
        org.junit.Assert.assertTrue("", Double.valueOf(new Lit(5.0).<Double>accept(this.makeEval())).equals(5.0));
    }

    public Eval makeEval() {
        return new Eval();
    }
}
