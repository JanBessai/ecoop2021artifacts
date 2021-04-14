package trivially.ep;

import org.junit.Assert;
import org.junit.Test;
import trivially.ep.m6.*;

public class M6Test {

    public interface TestTemplate extends M5Test.TestTemplate {
        default void test() {
            M5Test.TestTemplate.super.test();

            Exp lit1 = lit(1.0);
            Exp lit2 = lit(2.0);
            Exp mult1 = mult(lit1, lit2);
            Exp divd1 = divd(lit1, lit2);
            Exp add1 = add(lit1, lit2);
            Exp sub1 = sub(lit1, lit2);
            Exp neg1 = neg(lit1);

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

            Assert.assertTrue(sub(lit(1.0), lit(73.0)).equals(sub(lit(1.0), lit(73.0))));
            Assert.assertFalse(mult(divd(lit(5.0), lit(2.0)), lit(4.0)).equals(mult(divd(lit(5.0), lit(2.0)), lit(3.0))));
            Assert.assertTrue(mult(divd(lit(5.0), lit(2.0)), lit(4.0)).equals(mult(divd(lit(5.0), lit(2.0)), lit(4.0))));
            Assert.assertTrue(neg(mult(divd(lit(5.0), lit(2.0)), lit(4.0))).equals(neg(mult(divd(lit(5.0), lit(2.0)), lit(4.0)))));
            Assert.assertFalse(mult(divd(lit(5.0), lit(2.0)), lit(4.0)).equals(neg(mult(divd(lit(5.0), lit(2.0)), lit(4.0)))));
            Assert.assertFalse(divd(lit(6.0), lit(2.0)).equals(divd(lit(8.0), lit(2.0))));
            Assert.assertTrue(divd(lit(6.0), lit(2.0)).equals(divd(lit(6.0), lit(2.0))));
            Assert.assertTrue(add(lit(5.0), lit(3.0)).equals(add(lit(5.0), lit(3.0))));
            Assert.assertFalse(add(lit(5.0), lit(3.0)).equals(mult(divd(lit(5.0), lit(2.0)), lit(3.0))));
        }

        default Lit lit(Double d) { return new trivially.ep.m6.finalized.Lit(d); }
        default Add add(Exp left, Exp right) { return new trivially.ep.m6.finalized.Add(left, right); }
        default Sub sub(Exp left, Exp right) { return new trivially.ep.m6.finalized.Sub(left, right); }
        default Mult mult(Exp left, Exp right) { return new trivially.ep.m6.finalized.Mult(left, right); }
        default Neg neg(Exp inner) { return new trivially.ep.m6.finalized.Neg(inner); }
        default Divd divd(Exp left, Exp right) { return new trivially.ep.m6.finalized.Divd(left, right); }
    }
    private static class ActualTest implements TestTemplate{}

    @Test
    public void testTest() { new ActualTest().test(); }
}
