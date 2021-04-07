package interpreter.ep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static interpreter.ep.i1.MultByExpFactory.*;

public class TestSuite2_i1 {

    @Test
    public void test() {
        assertEquals("(1.0-2.0)", Sub(Lit(new Double(1.0)), Lit(new Double(2.0))).prettyp());
        assertEquals("((1.0-2.0)+(5.0+6.0))", Add(Sub(Lit(new Double(1.0)), Lit(new Double(2.0))), Add(Lit(new Double(5.0)), Lit(new Double(6.0)))).prettyp());
    }
}
