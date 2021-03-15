package vita.ep;

import vita.ep.m7.Exp;
import vita.ep.m7.finalized.Add;
import vita.ep.m7.finalized.Divd;
import vita.ep.m7.finalized.Lit;
import vita.ep.m7.finalized.Mult;
import vita.ep.m7.finalized.Neg;
import vita.ep.m7.finalized.Sub;
import org.junit.Test;

public class M7Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(this.add(this.lit(1.0), this.lit(12.0)).powby(this.lit(4.0)).eval()).equals(28561.0));
    }

    public Sub sub(Exp<vita.ep.m7.finalized.Visitor> left, Exp<vita.ep.m7.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Neg neg(Exp<vita.ep.m7.finalized.Visitor> inner) {
        return new Neg(inner);
    }

    public Mult mult(Exp<vita.ep.m7.finalized.Visitor> left, Exp<vita.ep.m7.finalized.Visitor> right) {
        return new Mult(left, right);
    }

    public Divd divd(Exp<vita.ep.m7.finalized.Visitor> left, Exp<vita.ep.m7.finalized.Visitor> right) {
        return new Divd(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<vita.ep.m7.finalized.Visitor> left, Exp<vita.ep.m7.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
