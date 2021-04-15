package interpreter.ep.m2;

import interpreter.ep.m1.EvalSub;

public class PrettypSub extends EvalSub implements PrettypExp {

    public PrettypSub(PrettypExp left, PrettypExp right) {
        super(left, right);
    }

    public String prettyp() {
        return "(" + ((PrettypExp) left).prettyp() + "-" + ((PrettypExp) right).prettyp() + ")";
    }
}
