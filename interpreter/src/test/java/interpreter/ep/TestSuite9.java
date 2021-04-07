package interpreter.ep;

import org.junit.Test;
import static interpreter.ep.m7i2.MergedExpFactory.*;
import static org.junit.Assert.*;

public class TestSuite9  {

    @Test
    public void test() {
        assertEquals(new Double(36.0), Power(Lit(new Double(6.0)), Lit(new Double(2.0))).eval());
        assertEquals("(25.0^-0.5)", Power(Lit(new Double(25.0)), Lit(new Double(-0.5))).prettyp());
        assertEquals(new Double(1.0), Power(Lit(new Double(10.0)), Lit(new Double(0.0))).eval());
        assertEquals("1.0", Power(Lit(new Double(10.0)), Lit(new Double(0.0))).simplify().prettyp());
    }
}
