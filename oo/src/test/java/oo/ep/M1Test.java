package oo.ep;

import org.junit.Test;

public class M1Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(new Sub(new Lit(1.0), new Lit(2.0)).eval()).equals(-1.0));
    }
}
