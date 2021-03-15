package ev.ep;

import org.junit.Test;

public class I1Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(new Add(new Lit(1.0), new Lit(2.0)).<Exp>accept(this.makeMultBy(new Lit(3.0))).<Double>accept(this.makeEval())).equals(9.0));
    }

    public EvalSub makeEval() {
        return new EvalSub();
    }

    public Prettyp makePrettyp() {
        return new Prettyp();
    }

    public MultBy makeMultBy(Exp other) {
        return new MultBy(other);
    }
}
