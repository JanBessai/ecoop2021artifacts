package interpreter.ep.m2;

import interpreter.ep.m0.EvalLit;

public class PrettypLit extends EvalLit implements PrettypExp {

    public PrettypLit(Double value) {
        super(value);
    }

    public String prettyp() {
        return "" + value;
    }
}
