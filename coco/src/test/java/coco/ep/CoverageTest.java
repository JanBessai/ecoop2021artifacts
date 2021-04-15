package coco.ep;

import org.junit.Test;
import util.Leaf;
import util.Node;

public class CoverageTest {
    public interface TestTemplate<FT> extends coco.ep.m7i2.Factory<FT>, M7i2Test.TestTemplate<FT> {
        default void test() {
            Exp<FT> expr1 = this.power(this.lit(5.0), this.lit(2.0));

            // complete coverage to 80%
            org.junit.Assert.assertTrue("",
                    convert(this.sub(this.neg(this.lit(2.0)), this.mult(this.sub(this.lit(1.0), this.lit(976.0)), this.add(this.mult(this.lit(1.0), this.lit(976.0)), this.divd(this.lit(1.0), this.lit(3.0)))))).astree().equals(new Node(83488, new Node(78192, new Node(76407, new Leaf<>(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(2130451, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(3.0))))))));

        }
    }
    private static class ActualTest implements CoverageTest.TestTemplate<coco.ep.m7i2.finalized.Exp>, coco.ep.m7i2.finalized.Factory {}

    @Test
    public void testTest() { new CoverageTest.ActualTest().test(); }
}
