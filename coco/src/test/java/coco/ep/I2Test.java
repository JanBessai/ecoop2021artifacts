package coco.ep;

import org.junit.Test;

public class I2Test {
    public interface TestTemplate<FT> extends coco.ep.i2.Factory<FT>, I1Test.TestTemplate<FT> {
        default void test() {
            I1Test.TestTemplate.super.test();
            org.junit.Assert.assertTrue("", Double.valueOf(this.convert(this.power(this.lit(2.0), this.lit(5.0))).eval()).equals(32.0));
        }
    }
    private static class ActualTest implements I2Test.TestTemplate<coco.ep.i1.finalized.Exp>, coco.ep.i2.finalized.Factory {}

    @Test
    public void testTest() { new I2Test.ActualTest().test(); }
}
