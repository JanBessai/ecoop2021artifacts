package interpreter.ep;

import interpreter.ep.m0.EvalExp;
import interpreter.ep.m2.PrettypExp;
import interpreter.ep.m6.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class M6Test {

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

            Assertions.assertTrue(sub(lit(1.0), lit(73.0)).equals(sub(lit(1.0), lit(73.0))));
            Assertions.assertFalse(mult(divd(lit(5.0), lit(2.0)), lit(4.0)).equals(mult(divd(lit(5.0), lit(2.0)), lit(3.0))));
            Assertions.assertTrue(mult(divd(lit(5.0), lit(2.0)), lit(4.0)).equals(mult(divd(lit(5.0), lit(2.0)), lit(4.0))));
            Assertions.assertTrue(neg(mult(divd(lit(5.0), lit(2.0)), lit(4.0))).equals(neg(mult(divd(lit(5.0), lit(2.0)), lit(4.0)))));
            Assertions.assertFalse(mult(divd(lit(5.0), lit(2.0)), lit(4.0)).equals(neg(mult(divd(lit(5.0), lit(2.0)), lit(4.0)))));
            Assertions.assertFalse(divd(lit(6.0), lit(2.0)).equals(divd(lit(8.0), lit(2.0))));
            Assertions.assertTrue(divd(lit(6.0), lit(2.0)).equals(divd(lit(6.0), lit(2.0))));
            Assertions.assertTrue(add(lit(5.0), lit(3.0)).equals(add(lit(5.0), lit(3.0))));
            Assertions.assertFalse(add(lit(5.0), lit(3.0)).equals(mult(divd(lit(5.0), lit(2.0)), lit(3.0))));
        }

        @Override default EqualsExp lit(Double d) { return new interpreter.ep.m6.EqualsLit(d); }
        @Override default EqualsExp add(EvalExp left, EvalExp right) { return new interpreter.ep.m6.EqualsAdd((EqualsExp) left, (EqualsExp) right); }
        @Override default EqualsExp sub(EvalExp left, EvalExp right) { return new interpreter.ep.m6.EqualsSub((EqualsExp) left, (EqualsExp) right); }
        @Override default EqualsExp mult(PrettypExp left, PrettypExp right) { return new interpreter.ep.m6.EqualsMult((EqualsExp) left, (EqualsExp) right); }
        @Override default EqualsExp neg(PrettypExp inner) { return new interpreter.ep.m6.EqualsNeg((EqualsExp) inner); }
        @Override default EqualsExp divd(PrettypExp left, PrettypExp right) { return new interpreter.ep.m6.EqualsDivd((EqualsExp) left, (EqualsExp) right); }
    }

    private static class ActualTest implements M6Test.TestTemplate {}

    @Test
    public void testTest() { new M6Test.ActualTest().test(); }
}