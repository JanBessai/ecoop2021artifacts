package trivially.ep;

import trivially.ep.i2.Exp;
import trivially.ep.i2.finalized.Add;
import trivially.ep.i2.finalized.Lit;
import trivially.ep.i2.finalized.Power;
import trivially.ep.i2.finalized.Sub;
import org.junit.Test;

public class I2Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(this.power(this.lit(2.0), this.lit(5.0)).eval()).equals(32.0));
    }

    public Sub sub(Exp<trivially.ep.i2.finalized.Visitor> left, Exp<trivially.ep.i2.finalized.Visitor> right) {
        return new Sub(left, right);
    }

    public Power power(Exp<trivially.ep.i2.finalized.Visitor> left, Exp<trivially.ep.i2.finalized.Visitor> right) {
        return new Power(left, right);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<trivially.ep.i2.finalized.Visitor> left, Exp<trivially.ep.i2.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
