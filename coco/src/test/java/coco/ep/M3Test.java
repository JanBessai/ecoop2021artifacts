package coco.ep;

import org.junit.Assert;
import org.junit.Test;

public class M3Test {

    public interface TestTemplate<FT> extends coco.ep.m3.Factory<FT>, M2Test.TestTemplate<FT> {
        default void test() {
            M2Test.TestTemplate.super.test();

            coco.ep.Exp<FT> expr1 = this.mult(this.lit(3.0), this.lit(2.0));
            org.junit.Assert.assertEquals("(3.0*2.0)", convert(expr1).prettyp());

            coco.ep.Exp<FT> expr2 = this.divd(this.lit(3.0), this.lit(2.0));
            org.junit.Assert.assertEquals("(3.0/2.0)", convert(expr2).prettyp());

            coco.ep.Exp<FT> expr3 = this.neg(this.lit(3.0));
            org.junit.Assert.assertEquals("(-3.0)", convert(expr3).prettyp());

            coco.ep.Exp<FT> expr4 = this.neg(expr1);
            org.junit.Assert.assertEquals("(-(3.0*2.0))", convert(expr4).prettyp());

            Assert.assertEquals(convert(this.neg(this.lit(1.0))).eval(), -1.0, 0.0);
            Assert.assertEquals("(-1.0)", convert(this.neg(this.lit(1.0))).prettyp());
            Assert.assertEquals("((5.0/2.0)*4.0)", convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).prettyp());
            Assert.assertEquals(10.0, convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).eval(), 0.0);
            Assert.assertEquals(convert(this.neg(this.lit(5.0))).eval(), -5.0, 0.0);
            Assert.assertEquals("(-(2.0*3.0))", convert(this.neg(this.mult(this.lit(2.0), this.lit(3.0)))).prettyp());
        }
    }
    private static class ActualTest implements M3Test.TestTemplate<coco.ep.m2.finalized.Exp>, coco.ep.m3.finalized.Factory {}

    @Test
    public void testTest() { new M3Test.ActualTest().test(); }
}
