package oo.ep;

import org.junit.Test;

public class I1Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(new Add(new Lit(1.0), new Lit(2.0)).multby(new Lit(3.0)).eval()).equals(9.0));
    }
}
