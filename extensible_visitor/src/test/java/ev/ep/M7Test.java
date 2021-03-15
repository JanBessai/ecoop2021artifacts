package ev.ep;

import org.junit.Test;

public class M7Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(new Add(new Lit(1.0), new Lit(12.0)).<Exp>accept(this.makePowBy(new Lit(4.0))).<Double>accept(this.makeEval())).equals(28561.0));
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

    public Astree makeAstree() {
        return new Astree();
    }

    public Id makeId() {
        return new Id();
    }

    public Equals makeEquals(Exp other) {
        return new Equals(other);
    }

    public PowBy makePowBy(Exp other) {
        return new PowBy(other);
    }
}
