package interpreter.ep.m0;

public class EvalAdd implements EvalExp {

    public EvalAdd(EvalExp left, EvalExp right) {
        this.left = left;
        this.right = right;
    }

    public EvalExp getLeft() {
        return this.left;
    }

    public EvalExp getRight() {
        return this.right;
    }

    protected EvalExp left;

    protected EvalExp right;

    public Double eval() {
        return getLeft().eval() + getRight().eval();
    }
}
