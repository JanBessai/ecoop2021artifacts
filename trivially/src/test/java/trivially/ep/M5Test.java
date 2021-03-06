package trivially.ep;

import org.junit.jupiter.api.Test;
import trivially.ep.m5.*;
import util.Leaf;
import util.Node;

public class M5Test {

    public interface TestTemplate extends M4Test.TestTemplate {
        default void test() {
            M4Test.TestTemplate.super.test();
           Exp lit1 = lit(1.0);
           Exp lit2 = lit(2.0);
           Exp mult1 = mult(lit1, lit2);
           Exp divd1 = divd(lit1, lit2);
           Exp add1 = add(lit1, lit2);
           Exp sub1 = sub(lit1, lit2);
           Exp neg1 = neg(lit1);

            org.junit.jupiter.api.Assertions.assertEquals(lit1.id(), lit2.id());
            org.junit.jupiter.api.Assertions.assertEquals(mult1.id(), mult(lit1, lit2).id());
            org.junit.jupiter.api.Assertions.assertEquals(divd1.id(), divd(lit1, lit2).id());
            org.junit.jupiter.api.Assertions.assertEquals(sub1.id(), sub(lit1, lit2).id());
            org.junit.jupiter.api.Assertions.assertEquals(add1.id(), add(lit1, lit2).id());
            org.junit.jupiter.api.Assertions.assertEquals(neg1.id(), neg(lit2).id());

            Node n1 = new Node(lit1.id(), new Leaf<>(1.0));
            Node n2 = new Node(lit2.id(),  new Leaf<>(2.0));
            util.Tree m3 = new Node(mult1.id(), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(m3, mult(lit1, lit2).astree());

            util.Tree d3 = new Node(divd1.id(), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(d3, divd(lit1, lit2).astree());

            util.Tree n3 = new Node(neg1.id(), n1);
            org.junit.jupiter.api.Assertions.assertEquals(n3, neg(lit1).astree());

            util.Tree a3 = new Node(add1.id(), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(a3, add(lit1, lit2).astree());

            util.Tree s3 = new Node(sub1.id(), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(s3, sub(lit1, lit2).astree());

            org.junit.jupiter.api.Assertions.assertTrue(sub(neg(lit(2.0)), mult(sub(lit(1.0), lit(976.0)), add(mult(lit(1.0), lit(976.0)), divd(lit(1.0), lit(3.0))))).astree().equals(new Node(83488, new Node(78192, new Node(76407, new Leaf<>(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(2130451, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(3.0))))))));
            org.junit.jupiter.api.Assertions.assertTrue(sub(neg(lit(2.0)), mult(sub(lit(1.0), lit(976.0)), add(mult(lit(1.0), lit(976.0)), divd(lit(1.0), lit(3.0))))).prettyp().equals("((-2.0)-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))"));
            org.junit.jupiter.api.Assertions.assertTrue(mult(mult(lit(2.0), lit(1.0)), add(lit(0.0), lit(7.0))).simplify().astree().equals(new Node(2409808, new Node(76407, new Leaf<>(2.0)), new Node(76407, new Leaf<>(7.0)))));
        }

        @Override default Exp lit(Double d) { return new trivially.ep.m5.finalized.Lit(d); }
        @Override default Exp add(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m5.finalized.Add((Exp) left, (Exp) right); }
        @Override default Exp sub(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m5.finalized.Sub((Exp) left, (Exp) right); }
        @Override default Exp mult(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m5.finalized.Mult((Exp) left, (Exp) right); }
        @Override default Exp neg(trivially.ep.m0.Exp inner) { return new trivially.ep.m5.finalized.Neg((Exp) inner); }
        @Override default Exp divd(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m5.finalized.Divd((Exp) left, (Exp) right); }
    }
    private static class ActualTest implements TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
