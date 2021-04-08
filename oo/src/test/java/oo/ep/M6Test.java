package oo.ep;

import org.junit.Assert;
import org.junit.Test;

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

            Assert.assertTrue(lit1.equals(lit1));
            Assert.assertFalse(lit1.equals(lit2));
            Assert.assertTrue(mult1.equals(mult1));
            Assert.assertFalse(mult1.equals(divd1));
            Assert.assertTrue(divd1.equals(divd1));
            Assert.assertFalse(divd1.equals(add1));
            Assert.assertTrue(add1.equals(add1));
            Assert.assertFalse(add1.equals(sub1));
            Assert.assertTrue(sub1.equals(sub1));
            Assert.assertFalse(sub1.equals(neg1));
            Assert.assertTrue(neg1.equals(neg1));
            Assert.assertFalse(neg1.equals(mult1));

            Assert.assertTrue(lit1.eql(lit1));
            Assert.assertFalse(lit1.eql(lit2));
            Assert.assertFalse(mult1.eql(lit2));
            Assert.assertTrue(mult1.eql(mult1));
            Assert.assertFalse(mult1.eql(divd1));
            Assert.assertTrue(divd1.eql(divd1));
            Assert.assertFalse(divd1.eql(add1));
            Assert.assertTrue(add1.eql(add1));
            Assert.assertFalse(add1.eql(sub1));
            Assert.assertTrue(sub1.eql(sub1));
            Assert.assertFalse(sub1.eql(neg1));
            Assert.assertTrue(neg1.eql(neg1));
            Assert.assertFalse(neg1.eql(mult1));

            Assert.assertTrue(new Sub(new Lit(1.0), new Lit(73.0)).equals(new Sub(new Lit(1.0), new Lit(73.0))));
            Assert.assertFalse(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).equals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0))));
            Assert.assertTrue(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).equals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))));
            Assert.assertTrue(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))).equals(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)))));
            Assert.assertFalse(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).equals(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)))));
            Assert.assertFalse(new Divd(new Lit(6.0), new Lit(2.0)).equals(new Divd(new Lit(8.0), new Lit(2.0))));
            Assert.assertTrue(new Divd(new Lit(6.0), new Lit(2.0)).equals(new Divd(new Lit(6.0), new Lit(2.0))));
            Assert.assertTrue(new Add(new Lit(5.0), new Lit(3.0)).equals(new Add(new Lit(5.0), new Lit(3.0))));
            Assert.assertFalse(new Add(new Lit(5.0), new Lit(3.0)).equals(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0))));
        }
    }
    private static class ActualTest implements TestTemplate{}

    @Test
    public void testTest() { new ActualTest().test(); }
}
