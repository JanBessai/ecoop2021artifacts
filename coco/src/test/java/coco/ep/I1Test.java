package coco.ep;

import org.junit.Test;

public class I1Test {
    public interface TestTemplate<FT> extends coco.ep.i1.Factory<FT>, M2Test.TestTemplate<FT> {
        default void test() {
            M2Test.TestTemplate.super.test();
            org.junit.Assert.assertTrue("", Double.valueOf(this.convert(this.convert(this.add(this.lit(1.0), this.lit(2.0))).multby(this.lit(3.0))).eval()).equals(9.0));
        }
    }
    private static class ActualTest implements I1Test.TestTemplate<coco.ep.i1.finalized.Exp>, coco.ep.i1.finalized.Factory {}


    @Test
    public void testTest() { new I1Test.ActualTest().test(); }
}
