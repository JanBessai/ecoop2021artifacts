package ev.ep;

import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.Sub;
import ev.ep.m3.Divd;
import ev.ep.m3.Mult;
import ev.ep.m3.Neg;
import ev.ep.m3.VisitorDivdMultNeg;
import ev.ep.m6.Eql;
import ev.ep.m6.Equals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

            Assertions.assertEquals(lit1, lit1);
            Assertions.assertNotEquals(lit1, lit2);
            Assertions.assertEquals(mult1, mult1);
            Assertions.assertNotEquals(mult1, divd1);
            Assertions.assertEquals(divd1, divd1);
            Assertions.assertNotEquals(divd1, add1);
            Assertions.assertEquals(add1, add1);
            Assertions.assertNotEquals(add1, sub1);
            Assertions.assertEquals(sub1, sub1);
            Assertions.assertNotEquals(sub1, neg1);
            Assertions.assertEquals(neg1, neg1);
            Assertions.assertNotEquals(neg1, mult1);

            org.junit.jupiter.api.Assertions.assertFalse(lit1.accept(makeEql(lit2)));
            org.junit.jupiter.api.Assertions.assertTrue(lit1.accept(makeEql(lit1)));
            org.junit.jupiter.api.Assertions.assertFalse(mult1.accept(makeEql(lit2)));
            org.junit.jupiter.api.Assertions.assertTrue(mult1.accept(makeEql(mult1)));
            org.junit.jupiter.api.Assertions.assertFalse(mult1.accept(makeEql(divd1)));
            org.junit.jupiter.api.Assertions.assertTrue(divd1.accept(makeEql(divd1)));
            org.junit.jupiter.api.Assertions.assertFalse(divd1.accept(makeEql(add1)));
            org.junit.jupiter.api.Assertions.assertTrue(add1.accept(makeEql(add1)));
            org.junit.jupiter.api.Assertions.assertFalse(add1.accept(makeEql(sub1)));
            org.junit.jupiter.api.Assertions.assertTrue(sub1.accept(makeEql(sub1)));
            org.junit.jupiter.api.Assertions.assertFalse(sub1.accept(makeEql(neg1)));
            org.junit.jupiter.api.Assertions.assertTrue(neg1.accept(makeEql(neg1)));
            org.junit.jupiter.api.Assertions.assertFalse(neg1.accept(makeEql(mult1)));

            org.junit.jupiter.api.Assertions.assertTrue(lit1.accept(makeEquals(lit1)));
            org.junit.jupiter.api.Assertions.assertFalse(mult1.accept(makeEquals(lit2)));
            org.junit.jupiter.api.Assertions.assertTrue(mult1.accept(makeEquals(mult1)));
            org.junit.jupiter.api.Assertions.assertFalse(mult1.accept(makeEquals(divd1)));
            org.junit.jupiter.api.Assertions.assertTrue(divd1.accept(makeEquals(divd1)));
            org.junit.jupiter.api.Assertions.assertFalse(divd1.accept(makeEquals(add1)));
            org.junit.jupiter.api.Assertions.assertTrue(add1.accept(makeEquals(add1)));
            org.junit.jupiter.api.Assertions.assertFalse(add1.accept(makeEquals(sub1)));
            org.junit.jupiter.api.Assertions.assertTrue(sub1.accept(makeEquals(sub1)));
            org.junit.jupiter.api.Assertions.assertFalse(sub1.accept(makeEquals(neg1)));
            org.junit.jupiter.api.Assertions.assertTrue(neg1.accept(makeEquals(neg1)));
            org.junit.jupiter.api.Assertions.assertFalse(neg1.accept(makeEquals(mult1)));

            org.junit.jupiter.api.Assertions.assertTrue(new Sub(new Lit(1.0), new Lit(73.0)).accept(makeEql(new Sub(new Lit(1.0), new Lit(73.0)))));
            org.junit.jupiter.api.Assertions.assertFalse(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(makeEql(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0)))));
            org.junit.jupiter.api.Assertions.assertTrue(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(makeEql(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)))));
            org.junit.jupiter.api.Assertions.assertTrue(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))).accept(makeEql(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))))));
            org.junit.jupiter.api.Assertions.assertFalse(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0)).accept(makeEql(new Neg(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(4.0))))));
            org.junit.jupiter.api.Assertions.assertFalse(new Divd(new Lit(6.0), new Lit(2.0)).accept(makeEql(new Divd(new Lit(8.0), new Lit(2.0)))));
            org.junit.jupiter.api.Assertions.assertTrue(new Divd(new Lit(6.0), new Lit(2.0)).accept(makeEql(new Divd(new Lit(6.0), new Lit(2.0)))));
            org.junit.jupiter.api.Assertions.assertTrue(new Add(new Lit(5.0), new Lit(3.0)).accept(makeEql(new Add(new Lit(5.0), new Lit(3.0)))));
            org.junit.jupiter.api.Assertions.assertFalse(new Add(new Lit(5.0), new Lit(3.0)).accept(makeEql(new Mult(new Divd(new Lit(5.0), new Lit(2.0)), new Lit(3.0)))));
        }

        default VisitorDivdMultNeg<Boolean> makeEql(Exp exp) { return new Eql(exp); }
        default VisitorDivdMultNeg<Boolean> makeEquals(Exp exp) { return new Equals(exp); }
    }

    private static class ActualTest implements M5Test.TestTemplate {}

    @Test
    public void testTest() { new ActualTest().test(); }
}
