package vita.ep;

import vita.ep.m0.Exp;
import vita.ep.m0.finalized.Add;
import vita.ep.m0.finalized.Lit;
import org.junit.Test;

public class M0Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(this.add(this.lit(1.0), this.lit(2.0)).eval()).equals(3.0));
        org.junit.Assert.assertTrue("", Double.valueOf(this.lit(5.0).eval()).equals(5.0));
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<vita.ep.m0.finalized.Visitor> left, Exp<vita.ep.m0.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
