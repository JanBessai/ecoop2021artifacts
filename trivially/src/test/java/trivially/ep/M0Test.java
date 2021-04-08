package trivially.ep;

import org.junit.Assert;
import trivially.ep.m0.Exp;
import trivially.ep.m0.finalized.Add;
import trivially.ep.m0.finalized.Lit;
import org.junit.Test;

public class M0Test {

    @Test
    public void testTest() {
        Assert.assertEquals(3.0, this.add(this.lit(1.0), this.lit(2.0)).eval(), 0.0);
        Assert.assertEquals(5.0, this.lit(5.0).eval(), 0.0);
    }

    public Lit lit(Double value) {
        return new Lit(value);
    }

    public Add add(Exp<trivially.ep.m0.finalized.Visitor> left, Exp<trivially.ep.m0.finalized.Visitor> right) {
        return new Add(left, right);
    }
}
