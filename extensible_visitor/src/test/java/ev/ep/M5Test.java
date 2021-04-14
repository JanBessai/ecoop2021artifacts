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

    public static class TestTemplate {
        void test() {
            Lit lit1 = new Lit(1.0);
            Lit lit2 = new Lit(2.0);
            Mult mult1 = new Mult(lit1, lit2);
            Divd divd1 = new Divd(lit1, lit2);
            Add add1 = new Add(lit1, lit2);
            Sub sub1 = new Sub(lit1, lit2);
            Neg neg1 = new Neg(lit1);

            org.junit.Assert.assertEquals(lit1.accept(this.makeId()), lit2.accept(this.makeId()));
            org.junit.Assert.assertEquals(mult1.accept(this.makeId()), new Mult(lit1, lit2).accept(this.makeId()));
            org.junit.Assert.assertEquals(divd1.accept(this.makeId()), new Divd(lit1, lit2).accept(this.makeId()));
            org.junit.Assert.assertEquals(sub1.accept(this.makeId()), new Sub(lit1, lit2).accept(this.makeId()));
            org.junit.Assert.assertEquals(add1.accept(this.makeId()), new Add(lit1, lit2).accept(this.makeId()));
            org.junit.Assert.assertEquals(neg1.accept(this.makeId()), new Neg(lit2).accept(this.makeId()));

            Node n1 = new Node(lit1.accept(this.makeId()), new Leaf<>(1.0));
            Node n2 = new Node(lit2.accept(this.makeId()), new Leaf<>(2.0));
            util.Tree m3 = new Node(mult1.accept(this.makeId()), n1, n2);
            org.junit.Assert.assertEquals(m3, new Mult(lit1, lit2).accept(this.makeAstree()));

            util.Tree d3 = new Node(divd1.accept(this.makeId()), n1, n2);
            org.junit.Assert.assertEquals(d3, new Divd(lit1, lit2).accept(this.makeAstree()));

            util.Tree n3 = new Node(neg1.accept(this.makeId()), n1);
            org.junit.Assert.assertEquals(n3, new Neg(lit1).accept(this.makeAstree()));

            util.Tree a3 = new Node(add1.accept(this.makeId()), n1, n2);
            org.junit.Assert.assertEquals(a3, new Add(lit1, lit2).accept(this.makeAstree()));

            util.Tree s3 = new Node(sub1.accept(this.makeId()), n1, n2);
            org.junit.Assert.assertEquals(s3, new Sub(lit1, lit2).accept(this.makeAstree()));

            org.junit.Assert.assertTrue(new Sub(new Neg(new Lit(2.0)), new Mult(new Sub(new Lit(1.0), new Lit(976.0)), new Add(new Mult(new Lit(1.0), new Lit(976.0)), new Divd(new Lit(1.0), new Lit(3.0))))).accept(this.makeAstree()).equals(new Node(83488, new Node(78192, new Node(76407, new Leaf<>(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(2130451, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(3.0))))))));
            Assert.assertEquals("((-2.0)-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))", new Sub(new Neg(new Lit(2.0)), new Mult(new Sub(new Lit(1.0), new Lit(976.0)), new Add(new Mult(new Lit(1.0), new Lit(976.0)), new Divd(new Lit(1.0), new Lit(3.0))))).accept(this.makePrettyp()));
            util.Tree tree = new Mult(new Mult(new Lit(2.0), new Lit(1.0)), new Add(new Lit(0.0), new Lit(7.0))).accept(this.makeSimplify()).accept(this.makeAstree());
            util.Tree tree2 = new Node(2409808, new Node(76407, new Leaf<>(2.0)), new Node(76407, new Leaf<>(7.0)));
            org.junit.Assert.assertEquals(tree, tree2);
        }

        public PrettypDivdMultNeg makePrettyp() {
            return new PrettypDivdMultNeg();
        }

        public Simplify makeSimplify() { return new Simplify();}

        public Id makeId() { return new Id(); }

        public Astree makeAstree() { return new Astree(); }
    }

    @Test
    public void testTest() { new TestTemplate().test(); }
}
