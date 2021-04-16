package oo.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M6Test {

    public interface TestTemplate extends M5Test.TestTemplate {
        default void test() {
            M5Test.TestTemplate.super.test();

            Exp lit1 = new Lit(1.0);
            Exp lit2 = new Lit(2.0);
            Exp mult1 = new Mult(lit1, lit2);
            Exp divd1 = new Divd(lit1, lit2);
            Exp add1 = new Add(lit1, lit2);
            Exp sub1 = new Sub(lit1, lit2);
            Exp neg1 = new Neg(lit1);

            Assertions.assertTrue(lit1.equals(lit1));
            Assertions.assertFalse(lit1.equals(lit2));
            Assertions.assertTrue(mult1.equals(mult1));
            Assertions.assertFalse(mult1.equals(divd1));
            Assertions.assertTrue(divd1.equals(divd1));
            Assertions.assertFalse(divd1.equals(add1));
            Assertions.assertTrue(add1.equals(add1));
            Assertions.assertFalse(add1.equals(sub1));
            Assertions.assertTrue(sub1.equals(sub1));
            Assertions.assertFalse(sub1.equals(neg1));
            Assertions.assertTrue(neg1.equals(neg1));
            Assertions.assertFalse(neg1.equals(mult1));

            Assertions.assertTrue(lit1.eql(lit1));
            Assertions.assertFalse(lit1.eql(lit2));
            Assertions.assertFalse(mult1.eql(lit2));
            Assertions.assertTrue(mult1.eql(mult1));
            Assertions.assertFalse(mult1.eql(divd1));
            Assertions.assertTrue(divd1.eql(divd1));
            Assertions.assertFalse(divd1.eql(add1));
            Assertions.assertTrue(add1.eql(add1));
            Assertions.assertFalse(add1.eql(sub1));
            Assertions.assertTrue(sub1.eql(sub1));
            Assertions.assertFalse(sub1.eql(neg1));
            Assertions.assertTrue(neg1.eql(neg1));
            Assertions.assertFalse(neg1.eql(mult1));

            Assertions.assertTrue(new Sub(new Lit(1.0), new Lit(73.0)).equals(new Sub(new Lit(1.0), new Lit(73.0))));
            Assertions.assertFalse(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).equals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0))));
            Assertions.assertTrue(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).equals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))));
            Assertions.assertTrue(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))).equals(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)))));
            Assertions.assertFalse(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).equals(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)))));
            Assertions.assertFalse(new Divd(new Lit(6.0), new Lit(2.0)).equals(new Divd(new Lit(8.0), new Lit(2.0))));
            Assertions.assertTrue(new Divd(new Lit(6.0), new Lit(2.0)).equals(new Divd(new Lit(6.0), new Lit(2.0))));
            Assertions.assertTrue(new Add(new Lit(5.0), new Lit(3.0)).equals(new Add(new Lit(5.0), new Lit(3.0))));
            Assertions.assertFalse(new Add(new Lit(5.0), new Lit(3.0)).equals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0))));
        }
    }
    private static class ActualTest implements TestTemplate{}

    @Test
    public void testTest() { new ActualTest().test(); }
}
