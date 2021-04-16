package coco.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M3Test {

    public interface TestTemplate<FT> extends coco.ep.m3.Factory<FT>, M2Test.TestTemplate<FT> {
        default void test() {
            M2Test.TestTemplate.super.test();

            coco.ep.Exp<FT> expr1 = this.mult(this.lit(3.0), this.lit(2.0));
            org.junit.jupiter.api.Assertions.assertEquals("(3.0*2.0)", convert(expr1).prettyp());

            coco.ep.Exp<FT> expr2 = this.divd(this.lit(3.0), this.lit(2.0));
            org.junit.jupiter.api.Assertions.assertEquals("(3.0/2.0)", convert(expr2).prettyp());

            coco.ep.Exp<FT> expr3 = this.neg(this.lit(3.0));
            org.junit.jupiter.api.Assertions.assertEquals("(-3.0)", convert(expr3).prettyp());

            coco.ep.Exp<FT> expr4 = this.neg(expr1);
            org.junit.jupiter.api.Assertions.assertEquals("(-(3.0*2.0))", convert(expr4).prettyp());

            Assertions.assertEquals(convert(this.neg(this.lit(1.0))).eval(), -1.0, 0.0);
            Assertions.assertEquals("(-1.0)", convert(this.neg(this.lit(1.0))).prettyp());
            Assertions.assertEquals("((5.0/2.0)*4.0)", convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).prettyp());
            Assertions.assertEquals(10.0, convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).eval(), 0.0);
            Assertions.assertEquals(convert(this.neg(this.lit(5.0))).eval(), -5.0, 0.0);
            Assertions.assertEquals("(-(2.0*3.0))", convert(this.neg(this.mult(this.lit(2.0), this.lit(3.0)))).prettyp());
        }
    }
    private static class ActualTest implements M3Test.TestTemplate<coco.ep.m2.finalized.Exp>, coco.ep.m3.finalized.Factory {}

    @Test
    public void testTest() { new M3Test.ActualTest().test(); }
}
