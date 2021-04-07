package interpreter.ep;

import interpreter.ep.m5.AstreeIdzExp;
import interpreter.ep.m5.CollectSimplifyExpToAstreeIdzExpFactory;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import static interpreter.ep.m6.AstreeIdzExpToEqualsExpFactory.*;

public class TestSuite6 {

    @Test
    public void test() {
    	assertFalse(Sub(Lit(new Double(1.0)), Lit(new Double(976.0))).eql(Add(Lit(new Double(1.0)), Lit(new Double(976.0)))));

        assertFalse(Sub(Lit(new Double(1.0)), Lit(new Double(976.0))).astree().equals(Add(Lit(new Double(1.0)), Lit(new Double(976.0))).astree()));
        assertTrue(Sub(Lit(new Double(1.0)), Lit(new Double(976.0))).astree().equals(Sub(Lit(new Double(1.0)), Lit(new Double(976.0))).astree()));
        assertTrue(Sub(Neg(Lit(new Double(2.0))), Mult(Sub(Lit(new Double(1.0)), Lit(new Double(976.0))), Add(Mult(Lit(new Double(1.0)), Lit(new Double(976.0))), Divd(Lit(new Double(1.0)), Lit(new Double(3.0)))))).astree().equals(Sub(Neg(Lit(new Double(2.0))), Mult(Sub(Lit(new Double(1.0)), Lit(new Double(976.0))), Add(Mult(Lit(new Double(1.0)), Lit(new Double(976.0))), Divd(Lit(new Double(1.0)), Lit(new Double(3.0)))))).astree()));
        util.Tree leaf4 = new util.Leaf(2.0);
        util.Node node3 = new util.Node(78192, leaf4);
        util.Tree leaf9 = new util.Leaf(1.0);
        util.Tree leaf10 = new util.Leaf(976.0);
        util.Node node8 = new util.Node(83488, leaf9, leaf10);
        java.util.ArrayList<util.Tree> list13 = new java.util.ArrayList<>();
        util.Tree leaf15 = new util.Leaf(1.0);
        util.Tree leaf16 = new util.Leaf(976.0);
        util.Node node14 = new util.Node(2409808, leaf15, leaf16);
        java.util.ArrayList<util.Tree> list17 = new java.util.ArrayList<>();
        util.Tree leaf19 = new util.Leaf(1.0);
        util.Tree leaf20 = new util.Leaf(3.0);
        util.Node node18 = new util.Node(2130451, leaf19, leaf20);
        util.Node node12 = new util.Node(65665, node14, node18);
        util.Node node6 = new util.Node(2409808, node8, node12);
        util.Node node1 = new util.Node(83488, node3, node6);
        assertEquals(node1, Sub(Neg(Lit(new Double(2.0))), Mult(Sub(Lit(new Double(1.0)), Lit(new Double(976.0))), Add(Mult(Lit(new Double(1.0)), Lit(new Double(976.0))), Divd(Lit(new Double(1.0)), Lit(new Double(3.0)))))).astree());
        assertEquals("(-2.0-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))", Sub(Neg(Lit(new Double(2.0))), Mult(Sub(Lit(new Double(1.0)), Lit(new Double(976.0))), Add(Mult(Lit(new Double(1.0)), Lit(new Double(976.0))), Divd(Lit(new Double(1.0)), Lit(new Double(3.0)))))).prettyp());
        util.Tree leaf23 = new util.Leaf(2.0);
        util.Tree leaf24 = new util.Leaf(7.0);
        util.Node node22 = new util.Node(2409808, leaf23, leaf24);
        AstreeIdzExp other = Mult(Mult(Lit(new Double(2.0)), Lit(new Double(1.0))), Add(Lit(new Double(0.0)), Lit(new Double(7.0))));

        // Simplify is a producer method from the past that only knows how to produce CollectSimplifyExp
        // objects, which need to be upgraded
        assertEquals(node22, CollectSimplifyExpToAstreeIdzExpFactory.convert(other.simplify()).astree());
    }
}
