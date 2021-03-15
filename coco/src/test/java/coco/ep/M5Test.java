package coco.ep;

import coco.ep.m5.finalized.Factory;
import util.Leaf;
import util.Node;
import org.junit.Test;

public class M5Test {

    public interface TestTemplate<FT> extends coco.ep.m5.Factory<FT>, M4Test.TestTemplate<FT> {
        default void test() {
            M4Test.TestTemplate.super.test();
            org.junit.Assert.assertTrue("", this.convert(this.sub(this.neg(this.lit(2.0)), this.mult(this.sub(this.lit(1.0), this.lit(976.0)), this.add(this.mult(this.lit(1.0), this.lit(976.0)), this.divd(this.lit(1.0), this.lit(3.0)))))).astree().equals(new Node(83488, new Node(78192, new Node(76407, new Leaf<Double>(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(976.0))), new Node(2130451, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(3.0))))))));
            org.junit.Assert.assertTrue("", this.convert(this.sub(this.neg(this.lit(2.0)), this.mult(this.sub(this.lit(1.0), this.lit(976.0)), this.add(this.mult(this.lit(1.0), this.lit(976.0)), this.divd(this.lit(1.0), this.lit(3.0)))))).prettyp().equals("(-2.0-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))"));
            org.junit.Assert.assertTrue("", this.convert(this.convert(this.mult(this.mult(this.lit(2.0), this.lit(1.0)), this.add(this.lit(0.0), this.lit(7.0)))).simplify()).astree().equals(new Node(2409808, new Node(76407, new Leaf<Double>(2.0)), new Node(76407, new Leaf<Double>(7.0)))));
        }
    }
    private static class ActualTest implements M5Test.TestTemplate<coco.ep.m5.finalized.Exp>, coco.ep.m5.finalized.Factory {}

    @Test
    public void testTest() { new M5Test.ActualTest().test(); }
}
