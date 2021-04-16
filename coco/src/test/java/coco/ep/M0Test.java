package coco.ep;

import coco.ep.m0.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M0Test {
    public interface TestTemplate<FT> extends Factory<FT> {
        default void test() {
            Exp<FT> expr1 = this.add(this.lit(1.0), this.lit(2.0));
            org.junit.jupiter.api.Assertions.assertEquals(3.0, convert(expr1).eval(), 0.0);

            Exp<FT> expr2 = this.lit(2.0);
            org.junit.jupiter.api.Assertions.assertEquals(2.0, convert(expr2).eval(), 0.0);

            Assertions.assertEquals(3.0, convert(this.add(this.lit(1.0), this.lit(2.0))).eval(), 0.0);
            Assertions.assertEquals(5.0, convert(this.lit(5.0)).eval(), 0.0);
        }
    }

    private static class ActualTest implements TestTemplate<coco.ep.m0.finalized.Exp>, coco.ep.m0.finalized.Factory {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
