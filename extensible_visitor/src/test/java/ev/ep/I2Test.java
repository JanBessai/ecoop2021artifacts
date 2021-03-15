package ev.ep;

import org.junit.Test;

public class I2Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(new Power(new Lit(2.0), new Lit(5.0)).<Double>accept(this.makeEval())).equals(32.0));
    }

    public EvalPower makeEval() {
        return new EvalPower();
    }

    public PrettypPower makePrettyp() {
        return new PrettypPower();
    }

    public MultByPower makeMultBy(Exp other) {
        return new MultByPower(other);
    }
}
