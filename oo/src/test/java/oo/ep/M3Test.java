package oo.ep;

import org.junit.Test;

public class M3Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", Double.valueOf(new Neg(new Lit(1.0)).eval()).equals(-1.0));
        org.junit.Assert.assertTrue("", new Neg(new Lit(1.0)).prettyp().equals("-1.0"));
        org.junit.Assert.assertTrue("", new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).prettyp().equals("((5.0/2.0)*4.0)"));
        org.junit.Assert.assertTrue("", Double.valueOf(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).eval()).equals(10.0));
        org.junit.Assert.assertTrue("", Double.valueOf(new Neg(new Lit(5.0)).eval()).equals(-5.0));
        org.junit.Assert.assertTrue("", new Neg(new Mult(new Lit(2.0), new Lit(3.0))).prettyp().equals("-(2.0*3.0)"));
    }
}
