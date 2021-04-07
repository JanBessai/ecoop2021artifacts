package coco.ep;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class M4Test {
    public interface TestTemplate<FT> extends coco.ep.m4.Factory<FT>, M3Test.TestTemplate<FT> {
        default void test() {
            M3Test.TestTemplate.super.test();

            coco.ep.Exp<FT> expr1 = this.divd(this.lit(3.0), this.lit(1.0));
            org.junit.Assert.assertEquals("3.0", convert(convert(expr1).simplify()).prettyp());

            coco.ep.Exp<FT> expr2 = this.divd(this.lit(0.0), this.lit(2.0));
            org.junit.Assert.assertEquals("0.0", convert(convert(expr2).simplify()).prettyp());

            coco.ep.Exp<FT> expr3 = this.divd(this.lit(3.0), this.divd(this.lit(6.0), this.lit(2.0)));
            org.junit.Assert.assertEquals("1.0", convert(convert(expr3).simplify()).prettyp());

            coco.ep.Exp<FT> expr4 = this.neg(expr1);
            org.junit.Assert.assertEquals("(-3.0)", convert(convert(expr4).simplify()).prettyp());

            coco.ep.Exp<FT> expr6 = this.add(this.lit(-2.0), this.lit(2.0));
            org.junit.Assert.assertEquals("0.0", convert(convert(expr6).simplify()).prettyp());

            coco.ep.Exp<FT> expr7 = this.add(this.lit(-2.0), this.lit(0.0));
            org.junit.Assert.assertEquals("-2.0", convert(convert(expr7).simplify()).prettyp());

            coco.ep.Exp<FT> expr8 = this.add(this.lit(-2.0), this.lit(-5.0));
            org.junit.Assert.assertEquals("(-2.0+-5.0)", convert(convert(expr8).simplify()).prettyp());

            coco.ep.Exp<FT> sub2 = this.sub(this.lit(3.0), this.lit(3.0));
            org.junit.Assert.assertEquals("0.0", convert(convert(sub2).simplify()).prettyp());

            coco.ep.Exp<FT> neg2 = this.neg(this.lit(0.0));
            org.junit.Assert.assertEquals("0.0", convert(convert(neg2).simplify()).prettyp());

            Exp<FT> left = this.mult(this.lit(3.0), this.lit(1.0));
            Exp<FT> right = this.mult(this.lit(1.0), this.lit(9.0));
            coco.ep.Exp<FT> expr5 = this.divd(left, right);
            org.junit.Assert.assertEquals("(3.0/9.0)", convert(convert(expr5).simplify()).prettyp());

            Assert.assertEquals(convert(this.divd(this.divd(this.lit(5.0), this.lit(7.0)), this.sub(this.lit(7.0), this.mult(this.lit(2.0), this.lit(3.0))))).collect(), Arrays.asList(5.0, 7.0, 7.0, 2.0, 3.0));
            Assert.assertEquals(convert(this.add(this.lit(0.0), this.lit(0.0))).collect(), Arrays.asList(0.0, 0.0));
            Assert.assertEquals(convert(this.neg(this.lit(0.0))).collect(), Collections.singletonList(0.0));
            Assert.assertEquals(convert(this.mult(this.lit(1.0), this.lit(12.0))).collect(), Arrays.asList(1.0, 12.0));
            Assert.assertEquals(convert(this.mult(this.lit(13.0), this.lit(1.0))).collect(), Arrays.asList(13.0, 1.0));
            Assert.assertEquals("((5.0/2.0)*4.0)", convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).prettyp());
            Assert.assertEquals(10.0, convert(this.mult(this.divd(this.lit(5.0), this.lit(2.0)), this.lit(4.0))).eval(), 0.0);

            Exp<FT> h1 = this.mult(this.lit(3.0), this.lit(2.0));
            Exp<FT> h2 = this.mult(h1, h1);
            Exp<FT> threeDeep = this.mult(h2, h2);

            Exp<FT> mult1 = this.mult(lit(5.0), threeDeep);
            convert(mult1).truncate(1);
            org.junit.Assert.assertEquals("(5.0*1296.0)", convert(mult1).prettyp());

            Exp<FT> divd1 = this.divd(lit(5.0), threeDeep);
            convert(divd1).truncate(1);
            org.junit.Assert.assertEquals("(5.0/1296.0)", convert(divd1).prettyp());

            Exp<FT> neg1 = this.neg(threeDeep);
            convert(neg1).truncate(1);
            org.junit.Assert.assertEquals("(-1296.0)", convert(neg1).prettyp());

            Exp<FT> sub1 = this.sub(lit(5.0), threeDeep);
            convert(sub1).truncate(1);
            org.junit.Assert.assertEquals("(5.0-1296.0)", convert(sub1).prettyp());

            Exp<FT> base = this.mult(this.add(this.lit(3.0), this.lit(7.0)), this.lit(3.0));
            String baseBeforeTrunc = convert(base).prettyp();
            convert(base).truncate(3);
            org.junit.Assert.assertTrue("", convert(base).prettyp().equals(baseBeforeTrunc));

            Exp<FT> larger = this.sub(base, this.divd(base, this.lit(1.0)));
            String largerBeforeTrunc = convert(larger).prettyp();
            convert(larger).truncate(4);
            org.junit.Assert.assertTrue("", convert(larger).prettyp().equals(largerBeforeTrunc));

            Exp<FT> nd1 = this.neg(this.lit(1.0));
            Exp<FT> nd2 = this.neg(nd1);
            Exp<FT> nd3 = this.neg(nd2);
            org.junit.Assert.assertEquals("(-(-(-1.0)))", convert(nd3).prettyp());
            convert(nd3).truncate(2);

            // looks odd, but is right. The innermost one is the negation of -1.0
            org.junit.Assert.assertEquals("(-(--1.0))", convert(nd3).prettyp());

            convert(larger).truncate(3);
            Exp<FT> baseTrunc = this.mult(this.lit(10.0), this.lit(3.0));
            Assert.assertEquals( convert(base).prettyp(), convert(baseTrunc).prettyp());
            Exp<FT> largerTrunc = this.sub(baseTrunc, this.divd(baseTrunc, this.lit(1.0)));
            Assert.assertEquals(convert(larger).prettyp(), convert(largerTrunc).prettyp());
        }
    }
    private static class ActualTest implements M4Test.TestTemplate<coco.ep.m4.finalized.Exp>, coco.ep.m4.finalized.Factory {}

    @Test
    public void testTest() { new M4Test.ActualTest().test(); }
}
