package coco.ep;

import coco.ep.m0.finalized.Exp;
import org.junit.Test;

public class M2Test {

    public interface TestTemplate<FT> extends coco.ep.m2.Factory<FT>, M1Test.TestTemplate<FT> {
        default void test() {
            M1Test.TestTemplate.super.test();
            org.junit.Assert.assertTrue("", this.convert(this.sub(this.lit(1.0), this.lit(2.0))).prettyp().equals("(1.0-2.0)"));
            org.junit.Assert.assertTrue("", this.convert(this.add(this.sub(this.lit(1.0), this.lit(2.0)), this.add(this.lit(5.0), this.lit(6.0)))).prettyp().equals("((1.0-2.0)+(5.0+6.0))"));
        }
    }
    private static class ActualTest implements M2Test.TestTemplate<coco.ep.m2.finalized.Exp>, coco.ep.m2.finalized.Factory {}

    @Test
    public void testTest() { new M2Test.ActualTest().test(); }
}
