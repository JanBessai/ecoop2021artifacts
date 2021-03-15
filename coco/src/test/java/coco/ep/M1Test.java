package coco.ep;
import org.junit.Test;

public class M1Test {

    public interface TestTemplate<FT> extends coco.ep.m1.Factory<FT>, M0Test.TestTemplate<FT> {
        default void test() {
            M0Test.TestTemplate.super.test();
            org.junit.Assert.assertTrue("", Double.valueOf(this.convert(this.sub(this.lit(1.0), this.lit(2.0))).eval()).equals(-1.0));
        }
    }
    private static class ActualTest implements M1Test.TestTemplate<coco.ep.m0.finalized.Exp>, coco.ep.m1.finalized.Factory {}

    @Test
    public void testTest() { new M1Test.ActualTest().test(); }
}
