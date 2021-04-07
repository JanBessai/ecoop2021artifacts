package coco.ep;
import org.junit.Assert;
import org.junit.Test;

public class M1Test {

    public interface TestTemplate<FT> extends coco.ep.m1.Factory<FT>, M0Test.TestTemplate<FT> {
        default void test() {
            M0Test.TestTemplate.super.test();

            Exp<FT> expr1 = this.sub(this.lit(1.0), this.lit(2.0));
            org.junit.Assert.assertEquals(-1.0, convert(expr1).eval(), 0.0);

            Exp<FT> expr2 = this.lit(2.0);
            org.junit.Assert.assertEquals(2.0, convert(expr2).eval(), 0.0);
            Assert.assertEquals(convert(this.sub(this.lit(1.0), this.lit(2.0))).eval(), -1.0, 0.0);
        }
    }
    private static class ActualTest implements M1Test.TestTemplate<coco.ep.m0.finalized.Exp>, coco.ep.m1.finalized.Factory {}

    @Test
    public void testTest() { new M1Test.ActualTest().test(); }
}
