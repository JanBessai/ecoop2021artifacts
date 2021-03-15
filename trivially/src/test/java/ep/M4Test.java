package trivially.ep;

import trivially.ep.m4.Exp;
import trivially.ep.m4.finalized.Add;
import trivially.ep.m4.finalized.Divd;
import trivially.ep.m4.finalized.Lit;
import trivially.ep.m4.finalized.Mult;
import trivially.ep.m4.finalized.Neg;
import trivially.ep.m4.finalized.Sub;
import org.junit.Test;

public class M4Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", this.divd(this.divd(this.lit(5.0), this.lit(7.0)), this.sub(this.lit(7.0), this.mult(this.lit(2.0), this.lit(3.0)))).collect().equals(java.util.Arrays.asList(5.0, 7.0, 7.0, 2.0, 3.0)));
        org.junit.Assert.assertTrue("", this.add(this.lit(0.0), this.lit(0.0)).collect().equals(java.util.Arrays.asList(0.0, 0.0)));
        org.junit.Assert.assertTrue("", this.neg(this.lit(0.0)).collect().equals(java.util.Arrays.asList(0.0)));
        org.junit.Assert.assertTrue("", this.mult(this.lit(1.0), this.lit(12.0)).collect().equals(java.util.Arrays.asList(1.0, 12.0)));
        org.junit.Assert.assertTrue("", this.mult(this.lit(13.0), this.lit(1.0)).collect().equals(java.util.Arrays.asList(13.0, 1.0)));
        org.junit.Assert.assertTrue("", this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)).prettyp().equals("((5.0/2.0)*4.0)"));
        org.junit.Assert.assertTrue("", Double.valueOf(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)).eval()).equals(10.0));
    }

    public Sub sub(Exp<trivially.ep.m4.finalized.Visitor> left, Exp<trivially.ep.m4.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Neg neg(Exp<trivially.ep.m4.finalized.Visitor> inner) {
        return new Neg(inner);
    }

    public Mult mult(Exp<trivially.ep.m4.finalized.Visitor> left, Exp<trivially.ep.m4.finalized.Visitor> right) {
        return new Mult(left, right);
    }

    public Divd divd(Exp<trivially.ep.m4.finalized.Visitor> left, Exp<trivially.ep.m4.finalized.Visitor> right) {
        return new Divd(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<trivially.ep.m4.finalized.Visitor> left, Exp<trivially.ep.m4.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
