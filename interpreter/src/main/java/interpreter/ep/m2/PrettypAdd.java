package interpreter.ep.m2;

import interpreter.ep.m0.EvalAdd;

public class PrettypAdd extends EvalAdd implements PrettypExp {

    public PrettypAdd(PrettypExp left, PrettypExp right) {
        super(left, right);
    }

    public PrettypExp getLeft() {
        return (PrettypExp) this.left;
    }

    public PrettypExp getRight() {
        return (PrettypExp) this.right;
    }

    public String prettyp() {
        return "(" + getLeft().prettyp() + "+" + getRight().prettyp() + ")";
    }
}
