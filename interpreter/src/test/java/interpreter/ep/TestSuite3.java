package interpreter.ep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static interpreter.ep.m2.PrettypExpFactory.*;
import static interpreter.ep.m3.PrettypExpFactory.*;

public class TestSuite3 {
    @Test
    public void test() {
        assertEquals(new Double(-1.0), Neg(Lit(new Double(1.0))).eval());
        assertEquals("-1.0", Neg(Lit(new Double(1.0))).prettyp());
        assertEquals("((5.0/2.0)*4.0)", Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(4.0))).prettyp());
        assertEquals(new Double(10.0), Mult(Divd(Lit(new Double(5.0)), Lit(new Double(2.0))), Lit(new Double(4.0))).eval());
        assertEquals(new Double(-5.0), Neg(Lit(new Double(5.0))).eval());
        assertEquals("-(2.0*3.0)", Neg(Mult(Lit(new Double(2.0)), Lit(new Double(3.0)))).prettyp());
    }
}
