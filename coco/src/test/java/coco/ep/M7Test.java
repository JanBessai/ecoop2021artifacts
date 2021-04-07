package coco.ep;

import org.junit.Assert;
import org.junit.Test;

public class M7Test {

    public interface TestTemplate<FT> extends coco.ep.m7.Factory<FT>, M6Test.TestTemplate<FT> {
        default void test() {
            M6Test.TestTemplate.super.test();

            Exp<FT> pby = convert(this.lit(3.0)).powby(this.lit(2.0));
            Exp<FT> d1 = convert(this.divd(this.lit(5.0), this.lit(2.0))).powby(this.lit(2.0));
            Exp<FT> m1 = convert(this.mult(this.lit(5.0), this.lit(2.0))).powby(this.lit(2.0));
            Exp<FT> a1 = convert(this.add(this.lit(5.0), this.lit(2.0))).powby(this.lit(2.0));
            Exp<FT> s1 = convert(this.sub(this.lit(5.0), this.lit(3.0))).powby(this.lit(2.0));
            Exp<FT> n1 = convert(this.neg(this.lit(5.0))).powby(this.lit(2.0));

            Assert.assertEquals(9.0, convert(pby).eval(), 0.0);
            Assert.assertEquals(6.25, convert(d1).eval(), 0.0);
            Assert.assertEquals(100.0, convert(m1).eval(), 0.0);
            Assert.assertEquals(49.0, convert(a1).eval(), 0.0);
            Assert.assertEquals(4.0, convert(s1).eval(), 0.0);
            Assert.assertEquals(25.0, convert(n1).eval(), 0.0);

            Assert.assertEquals(28561.0, convert(convert(this.add(this.lit(1.0), this.lit(12.0))).powby(this.lit(4.0))).eval(), 0.0);
        }
    }
    private static class ActualTest implements M7Test.TestTemplate<coco.ep.m7.finalized.Exp>, coco.ep.m7.finalized.Factory {}

    @Test
    public void testTest() { new M7Test.ActualTest().test(); }
}
