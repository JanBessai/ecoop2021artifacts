package vita.ep;

import vita.ep.m1.Exp;
import vita.ep.m1.finalized.Add;
import vita.ep.m1.finalized.Lit;
import vita.ep.m1.finalized.Sub;
import org.junit.Test;

public class M1Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(this.sub(this.lit(1.0), this.lit(2.0)).eval()).equals(-1.0));
    }

    public Sub sub(Exp<vita.ep.m1.finalized.Visitor> left, Exp<vita.ep.m1.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<vita.ep.m1.finalized.Visitor> left, Exp<vita.ep.m1.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
