package trivially.ep;

import trivially.ep.i1.Exp;
import trivially.ep.i1.finalized.Add;
import trivially.ep.i1.finalized.Lit;
import trivially.ep.i1.finalized.Sub;
import org.junit.Test;

public class I1Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(this.add(this.lit(1.0), this.lit(2.0)).multby(this.lit(3.0)).eval()).equals(9.0));
    }

    public Sub sub(Exp<trivially.ep.i1.finalized.Visitor> left, Exp<trivially.ep.i1.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<trivially.ep.i1.finalized.Visitor> left, Exp<trivially.ep.i1.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
