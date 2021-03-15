package coco.ep;

import org.junit.Test;

public class M4Test {
    public interface TestTemplate<FT> extends coco.ep.m4.Factory<FT>, M3Test.TestTemplate<FT> {
        default void test() {
            M3Test.TestTemplate.super.test();
            org.junit.Assert.assertTrue("", this.convert(this.divd(this.divd(this.lit(5.0), this.lit(7.0)), this.sub(this.lit(7.0), this.mult(this.lit(2.0), this.lit(3.0))))).collect().equals(java.util.Arrays.asList(5.0, 7.0, 7.0, 2.0, 3.0)));
            org.junit.Assert.assertTrue("", this.convert(this.add(this.lit(0.0), this.lit(0.0))).collect().equals(java.util.Arrays.asList(0.0, 0.0)));
            org.junit.Assert.assertTrue("", this.convert(this.neg(this.lit(0.0))).collect().equals(java.util.Arrays.asList(0.0)));
            org.junit.Assert.assertTrue("", this.convert(this.mult(this.lit(1.0), this.lit(12.0))).collect().equals(java.util.Arrays.asList(1.0, 12.0)));
            org.junit.Assert.assertTrue("", this.convert(this.mult(this.lit(13.0), this.lit(1.0))).collect().equals(java.util.Arrays.asList(13.0, 1.0)));
            org.junit.Assert.assertTrue("", this.convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).prettyp().equals("((5.0/2.0)*4.0)"));
            org.junit.Assert.assertTrue("", Double.valueOf(this.convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).eval()).equals(10.0));

            Exp<FT> base = this.mult(this.add(this.lit(3.0), this.lit(7.0)), this.lit(3.0));
            String baseBeforeTrunc = convert(base).prettyp();
            convert(base).truncate(3);
            org.junit.Assert.assertTrue("", convert(base).prettyp().equals(baseBeforeTrunc));

            Exp<FT> larger = this.sub(base, this.divd(base, this.lit(1.0)));
            String largerBeforeTrunc = convert(larger).prettyp();
            convert(larger).truncate(4);
            org.junit.Assert.assertTrue("", convert(larger).prettyp().equals(largerBeforeTrunc));

            convert(larger).truncate(3);
            Exp<FT> baseTrunc = this.mult(this.lit(10.0), this.lit(3.0));
            org.junit.Assert.assertTrue("", convert(base).prettyp().equals(convert(baseTrunc).prettyp()));
            Exp<FT> largerTrunc = this.sub(baseTrunc, this.divd(baseTrunc, this.lit(1.0)));
            org.junit.Assert.assertTrue("", convert(larger).prettyp().equals(convert(largerTrunc).prettyp()));
        }
    }
    private static class ActualTest implements M4Test.TestTemplate<coco.ep.m4.finalized.Exp>, coco.ep.m4.finalized.Factory {}

    @Test
    public void testTest() { new M4Test.ActualTest().test(); }
}
