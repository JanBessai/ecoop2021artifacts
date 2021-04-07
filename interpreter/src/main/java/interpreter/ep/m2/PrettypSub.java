package interpreter.ep.m2;

import interpreter.ep.m1.EvalSub;

public class PrettypSub extends EvalSub implements PrettypExp {

    public PrettypSub(PrettypExp left, PrettypExp right) {
        super(left, right);
    }

    public PrettypExp getLeft() {
        return (PrettypExp) this.left;
    }

    public PrettypExp getRight() {
        return (PrettypExp) this.right;
    }

    public String prettyp() {
        return "(" + getLeft().prettyp() + "-" + getRight().prettyp() + ")";
    }
}
