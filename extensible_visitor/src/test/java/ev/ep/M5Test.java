package ev.ep;

import ev.ep.m3.PrettypDivdMultNeg;
import ev.ep.m4.Simplify;
import ev.ep.m5.Astree;
import ev.ep.m5.Id;
import ev.ep.m3.Mult;
import ev.ep.m0.Lit;
import ev.ep.m0.Add;
import ev.ep.m1.Sub;
import ev.ep.m3.Neg;
import ev.ep.m3.Divd;

import org.junit.Assert;
import org.junit.Test;
import util.Leaf;
import util.Node;

public class M5Test {

    public interface TestTemplate extends M4Test.TestTemplate {
        default void test() {
            M4Test.TestTemplate.super.test();

            Lit lit1 = new Lit(1.0);
            Lit lit2 = new Lit(2.0);
            Mult mult1 = new Mult(lit1, lit2);
            Divd divd1 = new Divd(lit1, lit2);
            Add add1 = new Add(lit1, lit2);
            Sub sub1 = new Sub(lit1, lit2);
            Neg neg1 = new Neg(lit1);

            org.junit.Assert.assertEquals(lit1.accept(makeId()), lit2.accept(makeId()));
            org.junit.Assert.assertEquals(mult1.accept(makeId()), new Mult(lit1, lit2).accept(makeId()));
            org.junit.Assert.assertEquals(divd1.accept(makeId()), new Divd(lit1, lit2).accept(makeId()));
            org.junit.Assert.assertEquals(sub1.accept(makeId()), new Sub(lit1, lit2).accept(makeId()));
            org.junit.Assert.assertEquals(add1.accept(makeId()), new Add(lit1, lit2).accept(makeId()));
            org.junit.Assert.assertEquals(neg1.accept(makeId()), new Neg(lit2).accept(makeId()));

            Node n1 = new Node(lit1.accept(makeId()), new Leaf<>(1.0));
            Node n2 = new Node(lit2.accept(makeId()), new Leaf<>(2.0));
            util.Tree m3 = new Node(mult1.accept(makeId()), n1, n2);
            org.junit.Assert.assertEquals(m3, new Mult(lit1, lit2).accept(makeAstree()));

            util.Tree d3 = new Node(divd1.accept(makeId()), n1, n2);
            org.junit.Assert.assertEquals(d3, new Divd(lit1, lit2).accept(makeAstree()));

            util.Tree n3 = new Node(neg1.accept(makeId()), n1);
            org.junit.Assert.assertEquals(n3, new Neg(lit1).accept(makeAstree()));

            util.Tree a3 = new Node(add1.accept(makeId()), n1, n2);
            org.junit.Assert.assertEquals(a3, new Add(lit1, lit2).accept(makeAstree()));

            util.Tree s3 = new Node(sub1.accept(makeId()), n1, n2);
            org.junit.Assert.assertEquals(s3, new Sub(lit1, lit2).accept(makeAstree()));

            org.junit.Assert.assertTrue(new Sub(new Neg(new Lit(2.0)), new Mult(new Sub(new Lit(1.0), new Lit(976.0)), new Add(new Mult(new Lit(1.0), new Lit(976.0)), new Divd(new Lit(1.0), new Lit(3.0))))).accept(makeAstree()).equals(new Node(83488, new Node(78192, new Node(76407, new Leaf<>(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(2130451, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(3.0))))))));
            Assert.assertEquals("((-2.0)-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))", new Sub(new Neg(new Lit(2.0)), new Mult(new Sub(new Lit(1.0), new Lit(976.0)), new Add(new Mult(new Lit(1.0), new Lit(976.0)), new Divd(new Lit(1.0), new Lit(3.0))))).accept(makePrettyp()));
            util.Tree tree = new Mult(new Mult(new Lit(2.0), new Lit(1.0)), new Add(new Lit(0.0), new Lit(7.0))).accept(makeSimplify()).accept(makeAstree());
            util.Tree tree2 = new Node(2409808, new Node(76407, new Leaf<>(2.0)), new Node(76407, new Leaf<>(7.0)));
            org.junit.Assert.assertEquals(tree, tree2);
        }
    }

    static PrettypDivdMultNeg makePrettyp() { return new PrettypDivdMultNeg(); }
    static Simplify makeSimplify() { return new Simplify();}
    static Id makeId() { return new Id(); }
    static Astree makeAstree() { return new Astree(); }

    private static class ActualTest implements M5Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
