package interpreter.ep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static interpreter.ep.m5.AstreeIdzExpFactory.*;

public class TestSuite5  {

    @Test
    public void test() {
        assertEquals("(5.0+7.0)", Add(Add(Lit(new Double(5.0)), Lit(new Double(0.0))), Add(Lit(new Double(0.0)), Lit(new Double(7.0)))).simplify().prettyp());
        assertEquals("(5.0/7.0)", Divd(Divd(Lit(new Double(5.0)), Lit(new Double(7.0))), Sub(Lit(new Double(7.0)), Mult(Lit(new Double(2.0)), Lit(new Double(3.0))))).simplify().prettyp());
        assertEquals(new Double(0.0), Neg(Lit(new Double(0.0))).simplify().eval());
        assertEquals(new Double(5.0), Add(Lit(new Double(5.0)), Lit(new Double(0.0))).simplify().eval());
        assertEquals(new Double(7.0), Add(Lit(new Double(0.0)), Lit(new Double(7.0))).simplify().eval());
        assertEquals(new Double(13.0), Mult(Lit(new Double(13.0)), Lit(new Double(1.0))).simplify().eval());
        assertEquals(new Double(12.0), Mult(Lit(new Double(1.0)), Lit(new Double(12.0))).simplify().eval());
        assertEquals(new Double(0.0), Sub(Lit(new Double(7.0)), Lit(new Double(7.0))).simplify().eval());
        assertEquals(new Double(-1.0), Divd(Lit(new Double(5.0)), Lit(new Double(-5.0))).simplify().eval());
        assertEquals(new Double(1.0), Divd(Lit(new Double(-5.0)), Lit(new Double(-5.0))).simplify().eval());
        assertEquals(new Double(0.0), Divd(Lit(new Double(0.0)), Lit(new Double(-5.0))).simplify().eval());
    }
}
