package coco.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M2Test {

    public interface TestTemplate<FT> extends coco.ep.m2.Factory<FT>, M1Test.TestTemplate<FT> {
        default void test() {
            M1Test.TestTemplate.super.test();

            coco.ep.Exp<FT> expr1 = this.add(this.lit(1.0), this.lit(2.0));
            org.junit.jupiter.api.Assertions.assertEquals("(1.0+2.0)", convert(expr1).prettyp());

            Exp<FT> expr2 = this.lit(2.0);
            org.junit.jupiter.api.Assertions.assertEquals("2.0", convert(expr2).prettyp());

            Assertions.assertEquals("(1.0-2.0)", convert(this.sub(this.lit(1.0), this.lit(2.0))).prettyp());
            Assertions.assertEquals("((1.0-2.0)+(5.0+6.0))", convert(this.add(this.sub(this.lit(1.0), this.lit(2.0)), this.add(this.lit(5.0), this.lit(6.0)))).prettyp());
        }
    }
    private static class ActualTest implements M2Test.TestTemplate<coco.ep.m2.finalized.Exp>, coco.ep.m2.finalized.Factory {}

    @Test
    public void testTest() { new M2Test.ActualTest().test(); }
}
