package interpreter.ep;

import interpreter.ep.m6.EqualsExp;
import org.junit.Assert;
import org.junit.Test;

public class M6Test extends M5Test {

    public interface TestTemplate extends M5Test.TestTemplate {
        default void test() {
            M5Test.TestTemplate.super.test();
            EqualsExp lit1 = lit(1.0);
            EqualsExp lit2 = lit(2.0);
            EqualsExp mult1 = mult(lit1, lit2);
            EqualsExp divd1 = divd(lit1, lit2);
            EqualsExp add1 = add(lit1, lit2);
            EqualsExp sub1 = sub(lit1, lit2);
            EqualsExp neg1 = neg(lit1);

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
    }

    static EqualsExp lit(Double d) { return new interpreter.ep.m6.EqualsLit(d); }
    static EqualsExp add(EqualsExp left, EqualsExp right) { return new interpreter.ep.m6.EqualsAdd(left, right); }
    static EqualsExp sub(EqualsExp left, EqualsExp right) { return new interpreter.ep.m6.EqualsSub(left, right); }
    static EqualsExp mult(EqualsExp left, EqualsExp right) { return new interpreter.ep.m6.EqualsMult(left, right); }
    static EqualsExp neg(EqualsExp inner) { return new interpreter.ep.m6.EqualsNeg(inner); }
    static EqualsExp divd(EqualsExp left, EqualsExp right) { return new interpreter.ep.m6.EqualsDivd(left, right); }

    private static class ActualTest implements M6Test.TestTemplate {}

    @Test
    public void testTest() { new M6Test.ActualTest().test(); }
}