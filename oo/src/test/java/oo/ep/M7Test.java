package oo.ep;

import org.junit.Test;

public class M7Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(new Add(new Lit(1.0), new Lit(12.0)).powby(new Lit(4.0)).eval()).equals(28561.0));
    }
}
