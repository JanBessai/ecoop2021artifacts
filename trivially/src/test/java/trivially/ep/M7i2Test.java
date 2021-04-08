package trivially.ep;

import org.junit.Assert;
import trivially.ep.m7i2.Exp;
import trivially.ep.m7i2.finalized.*;
import org.junit.Test;

import java.util.Arrays;

public class M7i2Test {

    @Test
    public void testTest() {

        trivially.ep.m7i2.Exp<Visitor> m = this.mult(this.lit(2.0), this.lit(5.0));
        trivially.ep.m7i2.Exp<Visitor> mb = m.multby(this.lit(4.0));

        trivially.ep.m7i2.Exp<Visitor> pwr = this.power(this.lit(2.0), this.lit(5.0));
        trivially.ep.m7i2.Exp<Visitor> pwr2 = this.lit(2.0).powby(this.lit(5.0));

        Assert.assertFalse(this.power(this.lit(2.0), this.lit(5.0)).eql(mb));
        Assert.assertFalse(mb.eql(pwr));

        Assert.assertTrue(pwr.equals(pwr2));
        Assert.assertTrue(pwr.eql(pwr2));
        Assert.assertTrue(pwr2.eql(pwr));

        trivially.ep.m7i2.Exp<Visitor> neg = this.neg(this.lit(2.0));
        trivially.ep.m7i2.Exp<Visitor> neg2 = neg.powby(this.lit(5.0));
        Assert.assertEquals(-32.0, neg2.eval(), 0.0);

        trivially.ep.m7i2.Exp<Visitor> neg3 = neg.multby(this.lit(5.0));
        Assert.assertEquals(-10.0, neg3.eval(), 0.0);

        trivially.ep.m7i2.Exp<Visitor> divd2 = this.divd(this.lit(6.0), lit(2.0)).multby(this.lit(5.0));
        Assert.assertEquals(15.0, divd2.eval(), 0.0);

        Assert.assertEquals(40.0, mb.eval(), 0.0);
        Assert.assertEquals("((2.0*5.0)*4.0)", mb.prettyp());

        trivially.ep.m7i2.Exp<Visitor> expr1 = this.power(this.lit(3.0), this.lit(1.0));
        org.junit.Assert.assertEquals("3.0", expr1.simplify().prettyp());

        trivially.ep.m7i2.Exp<Visitor> expr2 = this.power(this.lit(1.0), this.lit(2.0));
        org.junit.Assert.assertEquals("1.0", expr2.simplify().prettyp());

        trivially.ep.m7i2.Exp<Visitor> expr3 = this.power(this.lit(3.0), this.lit(2.0));
        org.junit.Assert.assertEquals("(3.0^2.0)", expr3.simplify().prettyp());

        // 43046721 = ((9^2)^2)^2
        trivially.ep.m7i2.Exp<Visitor> h1 = this.power(this.lit(43046721.0), this.lit(0.5));
        trivially.ep.m7i2.Exp<Visitor> h2 = this.power(h1, this.lit(0.5));
        trivially.ep.m7i2.Exp<Visitor> threeDeep = this.power(h2, this.lit(0.5));

        // TODO: Add truncate to Trivially example
        // trivially.ep.m7i2.Exp<Visitor> pwr1 = this.power(lit(5.0), threeDeep);
        // pwr1.truncate(1);
        // org.junit.Assert.assertEquals("(5.0^9.0)", pwr1.prettyp());

        Assert.assertEquals(this.power(this.lit(1.0), this.lit(12.0)).collect(), Arrays.asList(1.0, 12.0));

        trivially.ep.m7i2.Exp<Visitor> pwr3 = this.power(lit(2.0), lit(3.0));
        trivially.ep.m7i2.Exp<Visitor> pwr4 = pwr3.powby(this.lit(4.0));
        org.junit.Assert.assertEquals("((2.0^3.0)^4.0)", pwr4.prettyp());
    }

    public Sub sub(Exp<trivially.ep.m7i2.finalized.Visitor> left, Exp<trivially.ep.m7i2.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Power power(Exp<trivially.ep.m7i2.finalized.Visitor> left, Exp<trivially.ep.m7i2.finalized.Visitor> right) {
        return new Power(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<trivially.ep.m7i2.finalized.Visitor> left, Exp<trivially.ep.m7i2.finalized.Visitor> right) {
        return new Add(left, right);
    }

    public Neg neg(Exp<trivially.ep.m7i2.finalized.Visitor> inner) {
        return new Neg(inner);
    }

    public Mult mult(Exp<trivially.ep.m7i2.finalized.Visitor> left, Exp<trivially.ep.m7i2.finalized.Visitor> right) {
        return new Mult(left, right);
    }

    public Divd divd(Exp<trivially.ep.m7i2.finalized.Visitor> left, Exp<trivially.ep.m7i2.finalized.Visitor> right) {
        return new Divd(left, right);
    }
}
