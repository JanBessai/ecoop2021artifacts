package oo.ep;

import org.junit.Test;

public class I2Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(new Power(new Lit(2.0), new Lit(5.0)).eval()).equals(32.0));
    }
}
