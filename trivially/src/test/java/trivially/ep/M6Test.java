package trivially.ep;

import org.junit.Assert;
import trivially.ep.m6.Exp;
import trivially.ep.m6.finalized.Add;
import trivially.ep.m6.finalized.Divd;
import trivially.ep.m6.finalized.Lit;
import trivially.ep.m6.finalized.Mult;
import trivially.ep.m6.finalized.Neg;
import trivially.ep.m6.finalized.Sub;
import org.junit.Test;

public class M6Test {

    @Test
    public void testTest() {
        Assert.assertTrue(this.sub(this.lit(1.0), this.lit(73.0)).equals(this.sub(this.lit(1.0), this.lit(73.0))));
        Assert.assertFalse(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(3.0))));
        Assert.assertTrue(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))));
        Assert.assertTrue(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).equals(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))));
        Assert.assertFalse(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)).equals(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))));
        Assert.assertFalse(this.divd(this.lit(6.0), this.lit(2.0)).equals(this.divd(this.lit(8.0), this.lit(2.0))));
        Assert.assertTrue(this.divd(this.lit(6.0), this.lit(2.0)).equals(this.divd(this.lit(6.0), this.lit(2.0))));
        Assert.assertTrue(this.add(this.lit(5.0), this.lit(3.0)).equals(this.add(this.lit(5.0), this.lit(3.0))));
        Assert.assertFalse(this.add(this.lit(5.0), this.lit(3.0)).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(3.0))));
    }

    public Sub sub(Exp<trivially.ep.m6.finalized.Visitor> left, Exp<trivially.ep.m6.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Neg neg(Exp<trivially.ep.m6.finalized.Visitor> inner) {
        return new Neg(inner);
    }

    public Mult mult(Exp<trivially.ep.m6.finalized.Visitor> left, Exp<trivially.ep.m6.finalized.Visitor> right) {
        return new Mult(left, right);
    }

    public Divd divd(Exp<trivially.ep.m6.finalized.Visitor> left, Exp<trivially.ep.m6.finalized.Visitor> right) {
        return new Divd(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<trivially.ep.m6.finalized.Visitor> left, Exp<trivially.ep.m6.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
