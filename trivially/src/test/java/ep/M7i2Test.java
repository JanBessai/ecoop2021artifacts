package trivially.ep;

import trivially.ep.m7i2.Exp;
import trivially.ep.m7i2.finalized.Add;
import trivially.ep.m7i2.finalized.Divd;
import trivially.ep.m7i2.finalized.Lit;
import trivially.ep.m7i2.finalized.Mult;
import trivially.ep.m7i2.finalized.Neg;
import trivially.ep.m7i2.finalized.Power;
import trivially.ep.m7i2.finalized.Sub;
import org.junit.Test;

public class M7i2Test {

    @Test
    public void testTest() {
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
