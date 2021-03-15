package coco.ep;

import org.junit.Test;

public class M7i2Test {
    public interface TestTemplate<FT> extends coco.ep.m7i2.Factory<FT>, M7Test.TestTemplate<FT>, I2Test.TestTemplate<FT> {
        default void test() {
            M7Test.TestTemplate.super.test();
            I2Test.TestTemplate.super.test();
        }
    }
    private static class ActualTest implements M7i2Test.TestTemplate<coco.ep.m7i2.finalized.Exp>, coco.ep.m7i2.finalized.Factory {}

    @Test
    public void testTest() { new M7i2Test.ActualTest().test(); }
}
