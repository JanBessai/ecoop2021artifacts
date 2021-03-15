package coco.ep;

import org.junit.Test;

public class M3Test {

    public interface TestTemplate<FT> extends coco.ep.m3.Factory<FT>, M2Test.TestTemplate<FT> {
        default void test() {
            M2Test.TestTemplate.super.test();
            org.junit.Assert.assertTrue("", Double.valueOf(this.convert(this.neg(this.lit(1.0))).eval()).equals(-1.0));
            org.junit.Assert.assertTrue("", this.convert(this.neg(this.lit(1.0))).prettyp().equals("-1.0"));
            org.junit.Assert.assertTrue("", this.convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).prettyp().equals("((5.0/2.0)*4.0)"));
            org.junit.Assert.assertTrue("", Double.valueOf(this.convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).eval()).equals(10.0));
            org.junit.Assert.assertTrue("", Double.valueOf(this.convert(this.neg(this.lit(5.0))).eval()).equals(-5.0));
            org.junit.Assert.assertTrue("", this.convert(this.neg(this.mult(this.lit(2.0), this.lit(3.0)))).prettyp().equals("-(2.0*3.0)"));
        }
    }
    private static class ActualTest implements M3Test.TestTemplate<coco.ep.m2.finalized.Exp>, coco.ep.m3.finalized.Factory {}

    @Test
    public void testTest() { new M3Test.ActualTest().test(); }
}
