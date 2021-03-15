package coco.ep;

import coco.ep.m0.Factory;
import org.junit.Test;

public class M0Test {
    public interface TestTemplate<FT> extends Factory<FT> {
        default void test() {
            org.junit.Assert.assertTrue("", Double.valueOf(this.convert(this.add(this.lit(1.0), this.lit(2.0))).eval()).equals(3.0));
            org.junit.Assert.assertTrue("", Double.valueOf(this.convert(this.lit(5.0)).eval()).equals(5.0));
        }
    }

    private static class ActualTest implements TestTemplate<coco.ep.m0.finalized.Exp>, coco.ep.m0.finalized.Factory {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
