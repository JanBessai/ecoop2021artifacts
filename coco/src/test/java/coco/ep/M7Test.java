package coco.ep;

import coco.ep.m7.finalized.Factory;
import org.junit.Test;

public class M7Test {

    public interface TestTemplate<FT> extends coco.ep.m7.Factory<FT>, M6Test.TestTemplate<FT> {
        default void test() {
            M6Test.TestTemplate.super.test();
            org.junit.Assert.assertTrue("", Double.valueOf(this.convert(this.convert(this.add(this.lit(1.0), this.lit(12.0))).powby(this.lit(4.0))).eval()).equals(28561.0));
        }
    }
    private static class ActualTest implements M7Test.TestTemplate<coco.ep.m7.finalized.Exp>, coco.ep.m7.finalized.Factory {}

    @Test
    public void testTest() { new M7Test.ActualTest().test(); }
}
