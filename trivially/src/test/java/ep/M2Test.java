package trivially.ep;

import trivially.ep.m2.Exp;
import trivially.ep.m2.finalized.Add;
import trivially.ep.m2.finalized.Lit;
import trivially.ep.m2.finalized.Sub;
import org.junit.Test;

public class M2Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", this.sub(this.lit(1.0), this.lit(2.0)).prettyp().equals("(1.0-2.0)"));
        org.junit.Assert.assertTrue("", this.add(this.sub(this.lit(1.0), this.lit(2.0)), this.add(this.lit(5.0), this.lit(6.0))).prettyp().equals("((1.0-2.0)+(5.0+6.0))"));
    }

    public Sub sub(Exp<trivially.ep.m2.finalized.Visitor> left, Exp<trivially.ep.m2.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<trivially.ep.m2.finalized.Visitor> left, Exp<trivially.ep.m2.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
