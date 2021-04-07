package interpreter.ep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static interpreter.ep.m4.CollectSimplifyExpFactory.*;

public class TestSuite4 {

    @Test
    public void test() {
        java.util.List<Double> tmpList13 = new java.util.ArrayList<>();
        tmpList13.add(new Double(5.0));
        tmpList13.add(new Double(7.0));
        tmpList13.add(new Double(7.0));
        tmpList13.add(new Double(2.0));
        tmpList13.add(new Double(3.0));
        assertEquals(tmpList13, Divd(Divd(Lit(new Double(5.0)), Lit(new Double(7.0))), Sub(Lit(new Double(7.0)), Mult(Lit(new Double(2.0)), Lit(new Double(3.0))))).collect());
        java.util.List<Double> tmpList14 = new java.util.ArrayList<>();
        tmpList14.add(new Double(0.0));
        tmpList14.add(new Double(0.0));
        assertEquals(tmpList14, Add(Lit(new Double(0.0)), Lit(new Double(0.0))).collect());
        java.util.List<Double> tmpList15 = new java.util.ArrayList<>();
        tmpList15.add(new Double(0.0));
        assertEquals(tmpList15, Neg(Lit(new Double(0.0))).collect());
        java.util.List<Double> tmpList16 = new java.util.ArrayList<>();
        tmpList16.add(new Double(1.0));
        tmpList16.add(new Double(12.0));
        assertEquals(tmpList16, Mult(Lit(new Double(1.0)), Lit(new Double(12.0))).collect());
        java.util.List<Double> tmpList17 = new java.util.ArrayList<>();
        tmpList17.add(new Double(13.0));
        tmpList17.add(new Double(1.0));
        assertEquals(tmpList17, Mult(Lit(new Double(13.0)), Lit(new Double(1.0))).collect());
        assertEquals("-1.0", Neg(Lit(new Double(1.0))).prettyp());
        assertEquals("((5.0/2.0)*4.0)", Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(4.0))).prettyp());
        assertEquals(new Double(10.0), Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(4.0))).eval());
    }
}
