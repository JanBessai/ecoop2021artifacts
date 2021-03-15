package coco.ep;

import org.junit.Test;

public class M6Test {

    public interface TestTemplate<FT> extends coco.ep.m6.Factory<FT>, M5Test.TestTemplate<FT> {
        default void test() {
            M5Test.TestTemplate.super.test();
            org.junit.Assert.assertTrue("", Boolean.valueOf(this.convert(this.sub(this.lit(1.0), this.lit(73.0))).equals(this.sub(this.lit(1.0), this.lit(73.0)))).equals(true));
            org.junit.Assert.assertTrue("", Boolean.valueOf(this.convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(3.0)))).equals(false));
            org.junit.Assert.assertTrue("", Boolean.valueOf(this.convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))).equals(true));
            org.junit.Assert.assertTrue("", Boolean.valueOf(this.convert(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))).equals(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))))).equals(true));
            org.junit.Assert.assertTrue("", Boolean.valueOf(this.convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).equals(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))))).equals(false));
            org.junit.Assert.assertTrue("", Boolean.valueOf(this.convert(this.divd(this.lit(6.0), this.lit(2.0))).equals(this.divd(this.lit(8.0), this.lit(2.0)))).equals(false));
            org.junit.Assert.assertTrue("", Boolean.valueOf(this.convert(this.divd(this.lit(6.0), this.lit(2.0))).equals(this.divd(this.lit(6.0), this.lit(2.0)))).equals(true));
            org.junit.Assert.assertTrue("", Boolean.valueOf(this.convert(this.add(this.lit(5.0), this.lit(3.0))).equals(this.add(this.lit(5.0), this.lit(3.0)))).equals(true));
            org.junit.Assert.assertTrue("", Boolean.valueOf(this.convert(this.add(this.lit(5.0), this.lit(3.0))).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(3.0)))).equals(false));
        }
    }
    private static class ActualTest implements M6Test.TestTemplate<coco.ep.m6.finalized.Exp>, coco.ep.m6.finalized.Factory {}

    @Test
    public void testTest() { new M6Test.ActualTest().test(); }
}
