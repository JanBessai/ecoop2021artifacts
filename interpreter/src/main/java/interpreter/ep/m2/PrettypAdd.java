package interpreter.ep.m2;

import interpreter.ep.m0.EvalAdd;

public class PrettypAdd extends EvalAdd implements PrettypExp {

    public PrettypAdd(PrettypExp left, PrettypExp right) {
        super(left, right);
    }

    public String prettyp() {
        return "(" + ((PrettypExp)left).prettyp() + "+" + ((PrettypExp)right).prettyp() + ")";
    }
}
