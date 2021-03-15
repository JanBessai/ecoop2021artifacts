package ev.ep;

import org.junit.Test;

public class M6Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Sub(new Lit(1.0), new Lit(73.0)).<Boolean>accept(this.makeEquals(new Sub(new Lit(1.0), new Lit(73.0))))).equals(true));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).<Boolean>accept(this.makeEquals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0))))).equals(false));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).<Boolean>accept(this.makeEquals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))))).equals(true));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))).<Boolean>accept(this.makeEquals(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)))))).equals(true));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).<Boolean>accept(this.makeEquals(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)))))).equals(false));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Divd(new Lit(6.0), new Lit(2.0)).<Boolean>accept(this.makeEquals(new Divd(new Lit(8.0), new Lit(2.0))))).equals(false));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Divd(new Lit(6.0), new Lit(2.0)).<Boolean>accept(this.makeEquals(new Divd(new Lit(6.0), new Lit(2.0))))).equals(true));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Add(new Lit(5.0), new Lit(3.0)).<Boolean>accept(this.makeEquals(new Add(new Lit(5.0), new Lit(3.0))))).equals(true));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Add(new Lit(5.0), new Lit(3.0)).<Boolean>accept(this.makeEquals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0))))).equals(false));
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
}
