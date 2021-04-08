package coco.ep;

import coco.ep.m5.Exp;
import util.Leaf;
import util.Node;
import org.junit.Test;

public class M5Test {

    public interface TestTemplate<FT> extends coco.ep.m5.Factory<FT>, M4Test.TestTemplate<FT> {
        default void test() {
            M4Test.TestTemplate.super.test();
            Exp<FT> lit1 = convert(this.lit(1.0));
            Exp<FT> lit2 = convert(this.lit(2.0));
            Exp<FT> mult1 = convert(this.mult(lit1, lit2));
            Exp<FT> divd1 = convert(this.divd(lit1, lit2));
            Exp<FT> add1 = convert(this.add(lit1, lit2));
            Exp<FT> sub1 = convert(this.sub(lit1, lit2));
            Exp<FT> neg1 = convert(this.neg(lit1));

            org.junit.Assert.assertEquals(lit1.id(), lit2.id());
            org.junit.Assert.assertEquals(mult1.id(), convert(this.mult(lit1, lit2)).id());
            org.junit.Assert.assertEquals(convert(divd1).id(), convert(this.divd(lit1, lit2)).id());
            org.junit.Assert.assertEquals(convert(sub1).id(), convert(this.sub(lit1, lit2)).id());
            org.junit.Assert.assertEquals(convert(add1).id(), convert(this.add(lit1, lit2)).id());
            org.junit.Assert.assertEquals(convert(neg1).id(), convert(this.neg(lit2)).id());

            util.Node n1 = new util.Node(lit1.id(), new util.Leaf(1.0));
            util.Node n2 = new util.Node(lit2.id(),  new util.Leaf(2.0));
            util.Tree m3 = new util.Node(mult1.id(), n1, n2);
            org.junit.Assert.assertEquals(m3, convert(this.mult(lit1, lit2)).astree());

            util.Tree d3 = new util.Node(divd1.id(), n1, n2);
            org.junit.Assert.assertEquals(d3, convert(this.divd(lit1, lit2)).astree());

            util.Tree n3 = new util.Node(neg1.id(), n1);
            org.junit.Assert.assertEquals(n3, convert(this.neg(lit1)).astree());

            util.Tree a3 = new util.Node(add1.id(), n1, n2);
            org.junit.Assert.assertEquals(a3, convert(this.add(lit1, lit2)).astree());

            util.Tree s3 = new util.Node(sub1.id(), n1, n2);
            org.junit.Assert.assertEquals(s3, convert(this.sub(lit1, lit2)).astree());

            org.junit.Assert.assertTrue(convert(this.sub(this.neg(this.lit(2.0)), this.mult(this.sub(this.lit(1.0), this.lit(976.0)), this.add(this.mult(this.lit(1.0), this.lit(976.0)), this.divd(this.lit(1.0), this.lit(3.0)))))).astree().equals(new Node(83488, new Node(78192, new Node(76407, new Leaf<Double>(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(976.0))), new Node(2130451, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(3.0))))))));
            org.junit.Assert.assertTrue(convert(this.sub(this.neg(this.lit(2.0)), this.mult(this.sub(this.lit(1.0), this.lit(976.0)), this.add(this.mult(this.lit(1.0), this.lit(976.0)), this.divd(this.lit(1.0), this.lit(3.0)))))).prettyp().equals("((-2.0)-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))"));
            org.junit.Assert.assertTrue(convert(convert(this.mult(this.mult(this.lit(2.0), this.lit(1.0)), this.add(this.lit(0.0), this.lit(7.0)))).simplify()).astree().equals(new Node(2409808, new Node(76407, new Leaf<Double>(2.0)), new Node(76407, new Leaf<Double>(7.0)))));
        }
    }
    private static class ActualTest implements M5Test.TestTemplate<coco.ep.m5.finalized.Exp>, coco.ep.m5.finalized.Factory {}

    @Test
    public void testTest() { new M5Test.ActualTest().test(); }
}
