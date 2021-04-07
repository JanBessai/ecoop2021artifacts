package interpreter.ep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static interpreter.ep.m0.EvalExpFactory.*;
import static interpreter.ep.m1.EvalSubFactory.*;

public class TestSuite1  {

    @Test
    public void test() {
        assertEquals(new Double(-1.0), Sub(Lit(new Double(1.0)), Lit(new Double(2.0))).eval());
    }
}
