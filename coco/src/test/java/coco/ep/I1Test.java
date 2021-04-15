package coco.ep;

import org.junit.Assert;
import org.junit.Test;

public class I1Test {
    public interface TestTemplate<FT> extends coco.ep.i1.Factory<FT>, M2Test.TestTemplate<FT> {
        default void test() {
            M2Test.TestTemplate.super.test();

            Assert.assertEquals(-3.0, convert(convert(this.sub(this.lit(1.0), this.lit(2.0))).multby(this.lit(3.0))).eval(), 0.0);

            Assert.assertEquals(9.0, convert(convert(this.add(this.lit(1.0), this.lit(2.0))).multby(this.lit(3.0))).eval(), 0.0);
        }
    }
    private static class ActualTest implements I1Test.TestTemplate<coco.ep.i1.finalized.Exp>, coco.ep.i1.finalized.Factory {}

    @Test
    public void testTest() { new I1Test.ActualTest().test(); }
}
