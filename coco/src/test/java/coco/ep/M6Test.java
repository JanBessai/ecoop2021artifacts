package coco.ep;

import coco.ep.m5.Exp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M6Test {

    public interface TestTemplate<FT> extends coco.ep.m6.Factory<FT>, M5Test.TestTemplate<FT> {
        default void test() {
            M5Test.TestTemplate.super.test();

            coco.ep.m5.Exp<FT> lit1 = convert(this.lit(1.0));
            coco.ep.m5.Exp<FT> lit2 = convert(this.lit(2.0));
            coco.ep.m5.Exp<FT> mult1 = convert(this.mult(lit1, lit2));
            coco.ep.m5.Exp<FT> divd1 = convert(this.divd(lit1, lit2));
            coco.ep.m5.Exp<FT> add1 = convert(this.add(lit1, lit2));
            coco.ep.m5.Exp<FT> sub1 = convert(this.sub(lit1, lit2));
            Exp<FT> neg1 = convert(this.neg(lit1));

            Assertions.assertTrue(convert(lit1).equals(convert(lit1)));
            Assertions.assertFalse(convert(lit1).equals(convert(lit2)));
            Assertions.assertTrue(convert(mult1).equals(convert(mult1)));
            Assertions.assertFalse(convert(mult1).equals(convert(divd1)));
            Assertions.assertTrue(convert(divd1).equals(convert(divd1)));
            Assertions.assertFalse(convert(divd1).equals(convert(add1)));
            Assertions.assertTrue(convert(add1).equals(convert(add1)));
            Assertions.assertFalse(convert(add1).equals(convert(sub1)));
            Assertions.assertTrue(convert(sub1).equals(convert(sub1)));
            Assertions.assertFalse(convert(sub1).equals(convert(neg1)));
            Assertions.assertTrue(convert(neg1).equals(convert(neg1)));
            Assertions.assertFalse(convert(neg1).equals(convert(mult1)));

            Assertions.assertTrue(convert(lit1).eql(convert(lit1)));
            Assertions.assertFalse(convert(lit1).eql(convert(lit2)));
            Assertions.assertFalse(convert(mult1).eql(convert(lit2)));
            Assertions.assertTrue(convert(mult1).eql(convert(mult1)));
            Assertions.assertFalse(convert(mult1).eql(convert(divd1)));
            Assertions.assertTrue(convert(divd1).eql(convert(divd1)));
            Assertions.assertFalse(convert(divd1).eql(convert(add1)));
            Assertions.assertTrue(convert(add1).eql(convert(add1)));
            Assertions.assertFalse(convert(add1).eql(convert(sub1)));
            Assertions.assertTrue(convert(sub1).eql(convert(sub1)));
            Assertions.assertFalse(convert(sub1).eql(convert(neg1)));
            Assertions.assertTrue(convert(neg1).eql(convert(neg1)));
            Assertions.assertFalse(convert(neg1).eql(convert(mult1)));

            Assertions.assertTrue(convert(this.sub(this.lit(1.0), this.lit(73.0))).equals(this.sub(this.lit(1.0), this.lit(73.0))));
            Assertions.assertFalse(convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(3.0))));
            Assertions.assertTrue(convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))));
            Assertions.assertTrue(convert(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))).equals(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))));
            Assertions.assertFalse(convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).equals(this.neg(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0)))));
            Assertions.assertFalse(convert(this.divd(this.lit(6.0), this.lit(2.0))).equals(this.divd(this.lit(8.0), this.lit(2.0))));
            Assertions.assertTrue(convert(this.divd(this.lit(6.0), this.lit(2.0))).equals(this.divd(this.lit(6.0), this.lit(2.0))));
            Assertions.assertTrue(convert(this.add(this.lit(5.0), this.lit(3.0))).equals(this.add(this.lit(5.0), this.lit(3.0))));
            Assertions.assertFalse(convert(this.add(this.lit(5.0), this.lit(3.0))).equals(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(3.0))));
        }
    }
    private static class ActualTest implements M6Test.TestTemplate<coco.ep.m6.finalized.Exp>, coco.ep.m6.finalized.Factory {}

    @Test
    public void testTest() { new M6Test.ActualTest().test(); }
}
