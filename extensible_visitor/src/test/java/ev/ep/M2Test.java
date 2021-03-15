package ev.ep;

import org.junit.Test;

public class M2Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", new Sub(new Lit(1.0), new Lit(2.0)).<String>accept(this.makePrettyp()).equals("(1.0-2.0)"));
        org.junit.Assert.assertTrue("", new Add(new Sub(new Lit(1.0), new Lit(2.0)), new Add(new Lit(5.0), new Lit(6.0))).<String>accept(this.makePrettyp()).equals("((1.0-2.0)+(5.0+6.0))"));
    }

    public EvalSub makeEval() {
        return new EvalSub();
    }

    public Prettyp makePrettyp() {
        return new Prettyp();
    }
}
