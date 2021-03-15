package trivially.ep;

import trivially.ep.m1.Exp;
import trivially.ep.m1.finalized.Add;
import trivially.ep.m1.finalized.Lit;
import trivially.ep.m1.finalized.Sub;
import org.junit.Test;

public class M1Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(this.sub(this.lit(1.0), this.lit(2.0)).eval()).equals(-1.0));
    }

    public Sub sub(Exp<trivially.ep.m1.finalized.Visitor> left, Exp<trivially.ep.m1.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<trivially.ep.m1.finalized.Visitor> left, Exp<trivially.ep.m1.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
