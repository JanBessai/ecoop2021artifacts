package trivially.ep;

import trivially.ep.m3.Exp;
import trivially.ep.m3.finalized.Add;
import trivially.ep.m3.finalized.Divd;
import trivially.ep.m3.finalized.Lit;
import trivially.ep.m3.finalized.Mult;
import trivially.ep.m3.finalized.Neg;
import trivially.ep.m3.finalized.Sub;
import org.junit.Test;

public class M3Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(this.neg(this.lit(1.0)).eval()).equals(-1.0));
        org.junit.Assert.assertTrue("", this.neg(this.lit(1.0)).prettyp().equals("-1.0"));
        org.junit.Assert.assertTrue("", this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)).prettyp().equals("((5.0/2.0)*4.0)"));
        org.junit.Assert.assertTrue("", Double.valueOf(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)).eval()).equals(10.0));
        org.junit.Assert.assertTrue("", Double.valueOf(this.neg(this.lit(5.0)).eval()).equals(-5.0));
        org.junit.Assert.assertTrue("", this.neg(this.mult(this.lit(2.0), this.lit(3.0))).prettyp().equals("-(2.0*3.0)"));
    }

    public Sub sub(Exp<trivially.ep.m3.finalized.Visitor> left, Exp<trivially.ep.m3.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Neg neg(Exp<trivially.ep.m3.finalized.Visitor> inner) {
        return new Neg(inner);
    }

    public Mult mult(Exp<trivially.ep.m3.finalized.Visitor> left, Exp<trivially.ep.m3.finalized.Visitor> right) {
        return new Mult(left, right);
    }

    public Divd divd(Exp<trivially.ep.m3.finalized.Visitor> left, Exp<trivially.ep.m3.finalized.Visitor> right) {
        return new Divd(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<trivially.ep.m3.finalized.Visitor> left, Exp<trivially.ep.m3.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
