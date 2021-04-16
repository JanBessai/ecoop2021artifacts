package ev.ep;

import ev.ep.m3.*;
import ev.ep.m4.Simplify;
import ev.ep.m5.Astree;
import ev.ep.m5.Id;
import ev.ep.m0.Lit;
import ev.ep.m0.Add;
import ev.ep.m1.Sub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

            org.junit.jupiter.api.Assertions.assertEquals(lit1.accept(makeId()), lit2.accept(makeId()));
            org.junit.jupiter.api.Assertions.assertEquals(mult1.accept(makeId()), new Mult(lit1, lit2).accept(makeId()));
            org.junit.jupiter.api.Assertions.assertEquals(divd1.accept(makeId()), new Divd(lit1, lit2).accept(makeId()));
            org.junit.jupiter.api.Assertions.assertEquals(sub1.accept(makeId()), new Sub(lit1, lit2).accept(makeId()));
            org.junit.jupiter.api.Assertions.assertEquals(add1.accept(makeId()), new Add(lit1, lit2).accept(makeId()));
            org.junit.jupiter.api.Assertions.assertEquals(neg1.accept(makeId()), new Neg(lit2).accept(makeId()));

            Node n1 = new Node(lit1.accept(makeId()), new Leaf<>(1.0));
            Node n2 = new Node(lit2.accept(makeId()), new Leaf<>(2.0));
            util.Tree m3 = new Node(mult1.accept(makeId()), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(m3, new Mult(lit1, lit2).accept(makeAstree()));

            util.Tree d3 = new Node(divd1.accept(makeId()), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(d3, new Divd(lit1, lit2).accept(makeAstree()));

            util.Tree n3 = new Node(neg1.accept(makeId()), n1);
            org.junit.jupiter.api.Assertions.assertEquals(n3, new Neg(lit1).accept(makeAstree()));

            util.Tree a3 = new Node(add1.accept(makeId()), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(a3, new Add(lit1, lit2).accept(makeAstree()));

            util.Tree s3 = new Node(sub1.accept(makeId()), n1, n2);
            org.junit.jupiter.api.Assertions.assertEquals(s3, new Sub(lit1, lit2).accept(makeAstree()));

            org.junit.jupiter.api.Assertions.assertTrue(new Sub(new Neg(new Lit(2.0)), new Mult(new Sub(new Lit(1.0), new Lit(976.0)), new Add(new Mult(new Lit(1.0), new Lit(976.0)), new Divd(new Lit(1.0), new Lit(3.0))))).accept(makeAstree()).equals(new Node(83488, new Node(78192, new Node(76407, new Leaf<>(2.0))), new Node(2409808, new Node(83488, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(65665, new Node(2409808, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(976.0))), new Node(2130451, new Node(76407, new Leaf<>(1.0)), new Node(76407, new Leaf<>(3.0))))))));
            Assertions.assertEquals("((-2.0)-((1.0-976.0)*((1.0*976.0)+(1.0/3.0))))", new Sub(new Neg(new Lit(2.0)), new Mult(new Sub(new Lit(1.0), new Lit(976.0)), new Add(new Mult(new Lit(1.0), new Lit(976.0)), new Divd(new Lit(1.0), new Lit(3.0))))).accept(makePrettyp()));
            util.Tree tree = new Mult(new Mult(new Lit(2.0), new Lit(1.0)), new Add(new Lit(0.0), new Lit(7.0))).accept(makeSimplify()).accept(makeAstree());
            util.Tree tree2 = new Node(2409808, new Node(76407, new Leaf<>(2.0)), new Node(76407, new Leaf<>(7.0)));
            org.junit.jupiter.api.Assertions.assertEquals(tree, tree2);
        }

        default VisitorDivdMultNeg<String> makePrettyp() { return new PrettypDivdMultNeg(); }
        default VisitorDivdMultNeg<Exp> makeSimplify() { return new Simplify();}
        default VisitorDivdMultNeg<Integer> makeId() { return new Id(); }
        default VisitorDivdMultNeg<util.Tree> makeAstree() { return new Astree(); }
    }

    private static class ActualTest implements M5Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
