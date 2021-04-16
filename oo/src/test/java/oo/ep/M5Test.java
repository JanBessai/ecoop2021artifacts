package oo.ep;

import org.junit.jupiter.api.Test;
import util.Leaf;
import util.Node;

public class M5Test {

    public interface TestTemplate extends M4Test.TestTemplate {
        default void test() {
            M4Test.TestTemplate.super.test();
           Exp lit1 = new Lit(1.0);
           Exp lit2 = new Lit(2.0);
           Exp mult1 = new Mult(lit1, lit2);
           Exp divd1 = new Divd(lit1, lit2);
           Exp add1 = new Add(lit1, lit2);
           Exp sub1 = new Sub(lit1, lit2);
           Exp neg1 = new Neg(lit1);

            org.junit.jupiter.api.Assertions.assertEquals(lit1.id(), lit2.id());
            org.junit.jupiter.api.Assertions.assertEquals(mult1.id(), new Mult(lit1, lit2).id());
            org.junit.jupiter.api.Assertions.assertEquals(divd1.id(), new Divd(lit1, lit2).id());
            org.junit.jupiter.api.Assertions.assertEquals(sub1.id(), new Sub(lit1, lit2).id());
            org.junit.jupiter.api.Assertions.assertEquals(add1.id(), new Add(lit1, lit2).id());
            org.junit.jupiter.api.Assertions.assertEquals(neg1.id(), new Neg(lit2).id());

            Node n1 = new Node(lit1.id(), new Leaf<>(1.0));
            Node n2 = new Node(lit2.id(),  new Leaf<>(2.0));
            util.Tree m3 = new Node(mult1.id(), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(m3, new Mult(lit1, lit2).astree());

            util.Tree d3 = new Node(divd1.id(), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(d3, new Divd(lit1, lit2).astree());

            util.Tree n3 = new Node(neg1.id(), n1);
            org.junit.jupiter.api.Assertions.assertEquals(n3, new Neg(lit1).astree());

            util.Tree a3 = new Node(add1.id(), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(a3, new Add(lit1, lit2).astree());

            util.Tree s3 = new Node(sub1.id(), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(s3, new Sub(lit1, lit2).astree());

            org.junit.jupiter.api.Assertions.assertTrue(new Sub(new Neg(new Lit(2.0)), new Mult(new Sub(new Lit(1.0), new Lit(976.0)), new Add(new Mult(new Lit(1.0), new Lit(976.0)), new Divd(new Lit(1.0), new Lit(3.0))))).astree().equals(new Node(83488, new Node(78192, new Node(76407, new Leaf<>(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(2130451, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(3.0))))))));
            org.junit.jupiter.api.Assertions.assertTrue(new Sub(new Neg(new Lit(2.0)), new Mult(new Sub(new Lit(1.0), new Lit(976.0)), new Add(new Mult(new Lit(1.0), new Lit(976.0)), new Divd(new Lit(1.0), new Lit(3.0))))).prettyp().equals("((-2.0)-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))"));
            org.junit.jupiter.api.Assertions.assertTrue(new Mult(new Mult(new Lit(2.0), new Lit(1.0)), new Add(new Lit(0.0), new Lit(7.0))).simplify().astree().equals(new Node(2409808, new Node(76407, new Leaf<>(2.0)), new Node(76407, new Leaf<>(7.0)))));
        }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
