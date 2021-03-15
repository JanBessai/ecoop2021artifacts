package oo.ep;

import org.junit.Test;

public class M6Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Sub(new Lit(1.0), new Lit(73.0)).equals(new Sub(new Lit(1.0), new Lit(73.0)))).equals(true));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).equals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0)))).equals(false));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).equals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)))).equals(true));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))).equals(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))))).equals(true));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).equals(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))))).equals(false));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Divd(new Lit(6.0), new Lit(2.0)).equals(new Divd(new Lit(8.0), new Lit(2.0)))).equals(false));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Divd(new Lit(6.0), new Lit(2.0)).equals(new Divd(new Lit(6.0), new Lit(2.0)))).equals(true));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Add(new Lit(5.0), new Lit(3.0)).equals(new Add(new Lit(5.0), new Lit(3.0)))).equals(true));
        org.junit.Assert.assertTrue("", Boolean.valueOf(new Add(new Lit(5.0), new Lit(3.0)).equals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0)))).equals(false));
    }
}
