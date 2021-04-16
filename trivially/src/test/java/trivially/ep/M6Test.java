package trivially.ep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

        @Override default Exp lit(Double d) { return new trivially.ep.m6.finalized.Lit(d); }
        @Override default Exp add(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m6.finalized.Add((Exp) left, (Exp) right); }
        @Override default Exp sub(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m6.finalized.Sub((Exp) left, (Exp) right); }
        @Override default Exp mult(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m6.finalized.Mult((Exp) left, (Exp) right); }
        @Override default Exp neg(trivially.ep.m0.Exp inner) { return new trivially.ep.m6.finalized.Neg((Exp) inner); }
        @Override default Exp divd(trivially.ep.m0.Exp left, trivially.ep.m0.Exp right) { return new trivially.ep.m6.finalized.Divd((Exp) left, (Exp) right); }
    }
    private static class ActualTest implements TestTemplate{}

    @Test
    public void testTest() { new ActualTest().test(); }
}
