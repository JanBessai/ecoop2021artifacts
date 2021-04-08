package trivially.ep;

import org.junit.Assert;
import trivially.ep.m7.Exp;
import trivially.ep.m7.finalized.Add;
import trivially.ep.m7.finalized.Divd;
import trivially.ep.m7.finalized.Lit;
import trivially.ep.m7.finalized.Mult;
import trivially.ep.m7.finalized.Neg;
import trivially.ep.m7.finalized.Sub;
import org.junit.Test;

public class M7Test {

    @Test
    public void testTest() {
        Assert.assertEquals(28561.0, this.add(this.lit(1.0), this.lit(12.0)).powby(this.lit(4.0)).eval(), 0.0);
    }

    public Sub sub(Exp<trivially.ep.m7.finalized.Visitor> left, Exp<trivially.ep.m7.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Neg neg(Exp<trivially.ep.m7.finalized.Visitor> inner) {
        return new Neg(inner);
    }

    public Mult mult(Exp<trivially.ep.m7.finalized.Visitor> left, Exp<trivially.ep.m7.finalized.Visitor> right) {
        return new Mult(left, right);
    }

    public Divd divd(Exp<trivially.ep.m7.finalized.Visitor> left, Exp<trivially.ep.m7.finalized.Visitor> right) {
        return new Divd(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<trivially.ep.m7.finalized.Visitor> left, Exp<trivially.ep.m7.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
