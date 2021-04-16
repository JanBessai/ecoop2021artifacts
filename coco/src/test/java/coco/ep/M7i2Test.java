package coco.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class M7i2Test {
    public interface TestTemplate<FT> extends coco.ep.m7i2.Factory<FT>, M7Test.TestTemplate<FT>, I2Test.TestTemplate<FT> {
        default void test() {
            M7Test.TestTemplate.super.test();
            I2Test.TestTemplate.super.test();

            Exp<FT> m = this.mult(this.lit(2.0), this.lit(5.0));
            Exp<FT> mb = convert(m).multby(this.lit(4.0));

            Exp<FT> pwr = this.power(this.lit(2.0), this.lit(5.0));
            Exp<FT> pwr2 = convert(this.lit(2.0)).powby(this.lit(5.0));

            Assertions.assertFalse(convert(pwr).eql(mb));
            Assertions.assertFalse(convert(mb).eql(pwr));

            Assertions.assertTrue(convert(pwr).equals(pwr2));
            Assertions.assertTrue(convert(pwr).eql(pwr2));
            Assertions.assertTrue(convert(pwr2).eql(pwr));

            Exp<FT> neg = this.neg(this.lit(2.0));
            Exp<FT> neg2 = convert(neg).powby(this.lit(5.0));
            Assertions.assertEquals(-32.0, convert(neg2).eval(), 0.0);

            Exp<FT> neg3 = convert(neg).multby(this.lit(5.0));
            Assertions.assertEquals(-10.0, convert(neg3).eval(), 0.0);

            Exp<FT> divd2 = convert(this.divd(this.lit(6.0), lit(2.0))).multby(this.lit(5.0));
            Assertions.assertEquals(15.0, convert(divd2).eval(), 0.0);

            Assertions.assertEquals(40.0, convert(mb).eval(), 0.0);
            Assertions.assertEquals("((2.0*5.0)*4.0)", convert(mb).prettyp());

            coco.ep.Exp<FT> expr1 = this.power(this.lit(3.0), this.lit(1.0));
            org.junit.jupiter.api.Assertions.assertEquals("3.0", convert(convert(expr1).simplify()).prettyp());

            coco.ep.Exp<FT> expr2 = this.power(this.lit(1.0), this.lit(2.0));
            org.junit.jupiter.api.Assertions.assertEquals("1.0", convert(convert(expr2).simplify()).prettyp());

            coco.ep.Exp<FT> expr3 = this.power(this.lit(3.0), this.lit(2.0));
            org.junit.jupiter.api.Assertions.assertEquals("(3.0^2.0)", convert(convert(expr3).simplify()).prettyp());

            // 43046721 = ((9^2)^2)^2
            Exp<FT> h1 = this.power(this.lit(43046721.0), this.lit(0.5));
            Exp<FT> h2 = this.power(h1, this.lit(0.5));
            Exp<FT> threeDeep = this.power(h2, this.lit(0.5));

            Exp<FT> pwr1 = this.power(lit(5.0), threeDeep);
            convert(pwr1).truncate(1);
            org.junit.jupiter.api.Assertions.assertEquals("(5.0^9.0)", convert(pwr1).prettyp());

            Assertions.assertEquals(convert(this.power(this.lit(1.0), this.lit(12.0))).collect(), Arrays.asList(1.0, 12.0));

            Exp<FT> pwr3 = this.power(lit(2.0), lit(3.0));
            Exp<FT> pwr4 = convert(pwr3).powby(this.lit(4.0));
            org.junit.jupiter.api.Assertions.assertEquals("((2.0^3.0)^4.0)", convert(pwr4).prettyp());
        }
    }
    private static class ActualTest implements M7i2Test.TestTemplate<coco.ep.m7i2.finalized.Exp>, coco.ep.m7i2.finalized.Factory {}

    @Test
    public void testTest() { new M7i2Test.ActualTest().test(); }
}
