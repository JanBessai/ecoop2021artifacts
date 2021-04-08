package interpreter.ep;

import interpreter.ep.m5.AstreeIdzExp;
import interpreter.ep.m5.AstreeIdzExpFactory;
import interpreter.ep.m5.CollectSimplifyExpToAstreeIdzExpFactory;
import org.junit.Test;
import util.Leaf;
import util.Node;
import util.Tree;

public class M5Test {
    public static class TestTemplate extends AstreeIdzExpFactory {
        void test() {
            AstreeIdzExp lit1 = lit(1.0);
            AstreeIdzExp lit2 = lit(2.0);
            AstreeIdzExp mult1 = mult(lit1, lit2);
            AstreeIdzExp divd1 = divd(lit1, lit2);
            AstreeIdzExp add1 = add(lit1, lit2);
            AstreeIdzExp sub1 = sub(lit1, lit2);
            AstreeIdzExp neg1 = neg(lit1);

            org.junit.Assert.assertEquals(lit1.idz(), lit2.idz());
            org.junit.Assert.assertEquals(mult1.idz(), mult(lit1, lit2).idz());
            org.junit.Assert.assertEquals(divd1.idz(), divd(lit1, lit2).idz());
            org.junit.Assert.assertEquals(sub1.idz(), sub(lit1, lit2).idz());
            org.junit.Assert.assertEquals(add1.idz(), add(lit1, lit2).idz());
            org.junit.Assert.assertEquals(neg1.idz(), neg(lit2).idz());

            Node n1 = new Node(lit1.idz(), new Leaf(1.0));
            Node n2 = new Node(lit2.idz(),  new Leaf(2.0));
            util.Tree m3 = new Node(mult1.idz(), n1, n2);
            Tree tree3 = mult(lit1, lit2).astree();
            org.junit.Assert.assertEquals(m3, tree3);

            util.Tree d3 = new Node(divd1.idz(), n1, n2);
            org.junit.Assert.assertEquals(d3, divd(lit1, lit2).astree());

            util.Tree n3 = new Node(neg1.idz(), n1);
            org.junit.Assert.assertEquals(n3, neg(lit1).astree());

            util.Tree a3 = new Node(add1.idz(), n1, n2);
            org.junit.Assert.assertEquals(a3, add(lit1, lit2).astree());

            util.Tree s3 = new Node(sub1.idz(), n1, n2);
            org.junit.Assert.assertEquals(s3, sub(lit1, lit2).astree());

            org.junit.Assert.assertTrue(sub(neg(lit(2.0)), mult(sub(lit(1.0), lit(976.0)), add(mult(lit(1.0), lit(976.0)), divd(lit(1.0), lit(3.0))))).astree().equals(new Node(83488, new Node(78192, new Node(76407, new Leaf<Double>(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(976.0))), new Node(2130451, new Node(76407, new Leaf<Double>(1.0)), new Node(76407, new Leaf<Double>(3.0))))))));
            org.junit.Assert.assertTrue(sub(neg(lit(2.0)), mult(sub(lit(1.0), lit(976.0)), add(mult(lit(1.0), lit(976.0)), divd(lit(1.0), lit(3.0))))).prettyp().equals("((-2.0)-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))"));
            org.junit.Assert.assertTrue(CollectSimplifyExpToAstreeIdzExpFactory.convert(mult(mult(lit(2.0), lit(1.0)), add(lit(0.0), lit(7.0))).simplify()).astree().equals(new Node(2409808, new Node(76407, new Leaf<Double>(2.0)), new Node(76407, new Leaf<Double>(7.0)))));
        }
    }

    @Test
    public void testTest() {
        new M4Test().testTest();
        new TestTemplate().test();
    }
}
