package vita.ep;

import vita.ep.m7i2.Exp;
import vita.ep.m7i2.finalized.Add;
import vita.ep.m7i2.finalized.Divd;
import vita.ep.m7i2.finalized.Lit;
import vita.ep.m7i2.finalized.Mult;
import vita.ep.m7i2.finalized.Neg;
import vita.ep.m7i2.finalized.Power;
import vita.ep.m7i2.finalized.Sub;
import org.junit.Test;

public class M7i2Test {

    @Test
    public void testTest() {
    }

    public Sub sub(Exp<vita.ep.m7i2.finalized.Visitor> left, Exp<vita.ep.m7i2.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Power power(Exp<vita.ep.m7i2.finalized.Visitor> left, Exp<vita.ep.m7i2.finalized.Visitor> right) {
        return new Power(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<vita.ep.m7i2.finalized.Visitor> left, Exp<vita.ep.m7i2.finalized.Visitor> right) {
        return new Add(left, right);
    }

    public Neg neg(Exp<vita.ep.m7i2.finalized.Visitor> inner) {
        return new Neg(inner);
    }

    public Mult mult(Exp<vita.ep.m7i2.finalized.Visitor> left, Exp<vita.ep.m7i2.finalized.Visitor> right) {
        return new Mult(left, right);
    }

    public Divd divd(Exp<vita.ep.m7i2.finalized.Visitor> left, Exp<vita.ep.m7i2.finalized.Visitor> right) {
        return new Divd(left, right);
    }
}
