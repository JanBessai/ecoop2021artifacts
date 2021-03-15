package oo.ep;

import util.Leaf;
import util.Node;
import org.junit.Test;

public class M5Test {

    @Test
    public void testTest() {
        org.junit.Assert.assertTrue("", new Sub(new Neg(new Lit(2.0)), new Mult(new Sub(new Lit(1.0), new Lit(976.0)), new Add(new Mult(new Lit(1.0), new Lit(976.0)), new Divd(new Lit(1.0), new Lit(3.0))))).astree().equals(new Node(83488, new Node(78192, new Node(76407, new Leaf<Double>(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(976.0))), new Node(2130451, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(3.0))))))));
        org.junit.Assert.assertTrue("", new Sub(new Neg(new Lit(2.0)), new Mult(new Sub(new Lit(1.0), new Lit(976.0)), new Add(new Mult(new Lit(1.0), new Lit(976.0)), new Divd(new Lit(1.0), new Lit(3.0))))).prettyp().equals("(-2.0-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))"));
        org.junit.Assert.assertTrue("", new Mult(new Mult(new Lit(2.0), new Lit(1.0)), new Add(new Lit(0.0), new Lit(7.0))).simplify().astree().equals(new Node(2409808, new Node(76407, new Leaf<Double>(2.0)), new Node(76407, new Leaf<Double>(7.0)))));
    }
}
