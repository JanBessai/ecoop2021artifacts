package interpreter.ep.m0;

public class EvalAdd implements EvalExp {

    public EvalAdd(EvalExp left, EvalExp right) {
        this.left = left;
        this.right = right;
    }

    protected EvalExp left;
    protected EvalExp right;

    public Double eval() {
        return left.eval() + right.eval();
    }
}
