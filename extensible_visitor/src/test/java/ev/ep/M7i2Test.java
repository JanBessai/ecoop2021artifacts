package ev.ep;

import org.junit.Test;

public class M7i2Test {

    @Test
    public void testTest() {
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

    public MultBy makeMultBy(Exp other) {
        return new MultBy(other);
    }

    public PowBy makePowBy(Exp other) {
        return new PowBy(other);
    }
}
