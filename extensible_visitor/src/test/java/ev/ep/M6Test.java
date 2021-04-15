package ev.ep;

import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.Sub;
import ev.ep.m3.Divd;
import ev.ep.m3.Mult;
import ev.ep.m3.Neg;
import ev.ep.m6.Eql;
import org.junit.Assert;
import org.junit.Test;

public class M6Test {

    public interface TestTemplate extends M5Test.TestTemplate {
        default void test() {
            M5Test.TestTemplate.super.test();
            Lit lit1 = new Lit(1.0);
            Lit lit2 = new Lit(2.0);
            Mult mult1 = new Mult(lit1, lit2);
            Divd divd1 = new Divd(lit1, lit2);
            Add add1 = new Add(lit1, lit2);
            Sub sub1 = new Sub(lit1, lit2);
            Neg neg1 = new Neg(lit1);

            Assert.assertEquals(lit1, lit1);
            Assert.assertNotEquals(lit1, lit2);
            Assert.assertEquals(mult1, mult1);
            Assert.assertNotEquals(mult1, divd1);
            Assert.assertEquals(divd1, divd1);
            Assert.assertNotEquals(divd1, add1);
            Assert.assertEquals(add1, add1);
            Assert.assertNotEquals(add1, sub1);
            Assert.assertEquals(sub1, sub1);
            Assert.assertNotEquals(sub1, neg1);
            Assert.assertEquals(neg1, neg1);
            Assert.assertNotEquals(neg1, mult1);

            org.junit.Assert.assertFalse(lit1.accept(makeEql(lit2)));
            org.junit.Assert.assertTrue(lit1.accept(makeEql(lit1)));
            org.junit.Assert.assertFalse(mult1.accept(makeEql(lit2)));
            org.junit.Assert.assertTrue(mult1.accept(makeEql(mult1)));
            org.junit.Assert.assertFalse(mult1.accept(makeEql(divd1)));
            org.junit.Assert.assertTrue(divd1.accept(makeEql(divd1)));
            org.junit.Assert.assertFalse(divd1.accept(makeEql(add1)));
            org.junit.Assert.assertTrue(add1.accept(makeEql(add1)));
            org.junit.Assert.assertFalse(add1.accept(makeEql(sub1)));
            org.junit.Assert.assertTrue(sub1.accept(makeEql(sub1)));
            org.junit.Assert.assertFalse(sub1.accept(makeEql(neg1)));
            org.junit.Assert.assertTrue(neg1.accept(makeEql(neg1)));
            org.junit.Assert.assertFalse(neg1.accept(makeEql(mult1)));

            org.junit.Assert.assertTrue(new Sub(new Lit(1.0), new Lit(73.0)).accept(makeEql(new Sub(new Lit(1.0), new Lit(73.0)))));
            org.junit.Assert.assertFalse(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(makeEql(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0)))));
            org.junit.Assert.assertTrue(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(makeEql(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)))));
            org.junit.Assert.assertTrue(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))).accept(makeEql(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))))));
            org.junit.Assert.assertFalse(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(makeEql(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))))));
            org.junit.Assert.assertFalse(new Divd(new Lit(6.0), new Lit(2.0)).accept(makeEql(new Divd(new Lit(8.0), new Lit(2.0)))));
            org.junit.Assert.assertTrue(new Divd(new Lit(6.0), new Lit(2.0)).accept(makeEql(new Divd(new Lit(6.0), new Lit(2.0)))));
            org.junit.Assert.assertTrue(new Add(new Lit(5.0), new Lit(3.0)).accept(makeEql(new Add(new Lit(5.0), new Lit(3.0)))));
            org.junit.Assert.assertFalse(new Add(new Lit(5.0), new Lit(3.0)).accept(makeEql(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0)))));
        }
    }

    static Eql makeEql(Exp exp) { return new Eql(exp); }

    private static class ActualTest implements M5Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
