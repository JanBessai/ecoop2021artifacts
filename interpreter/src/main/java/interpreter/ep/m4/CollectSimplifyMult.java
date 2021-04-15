package interpreter.ep.m4;

import interpreter.ep.m3.PrettypMult;

public class CollectSimplifyMult extends PrettypMult implements CollectSimplifyExp {

    public CollectSimplifyMult(CollectSimplifyExp left, CollectSimplifyExp right) {
        super(left, right);
    }

	public CollectSimplifyExp simplify() {
        double leftVal = left.eval();
        double rightVal = right.eval();
        if (leftVal == 0 || rightVal == 0) {
            return new CollectSimplifyLit(0.0);
        } else if (leftVal == 1) {
            return ((CollectSimplifyExp)right).simplify();
        } else if (rightVal == 1) {
            return ((CollectSimplifyExp)left).simplify();
        } else {
            return new CollectSimplifyMult(((CollectSimplifyExp)left).simplify(), ((CollectSimplifyExp)right).simplify());
        }
    }

    public void truncate (int level) {
        if (level > 1) {
            ((CollectSimplifyExp)left).truncate(level-1);
            ((CollectSimplifyExp)right).truncate(level-1);
        } else {
            left = new CollectSimplifyLit (left.eval());
            right = new CollectSimplifyLit (right.eval());
        }
    }

    public java.util.List<Double> collect() {
        java.util.List<Double> tmpList3 = new java.util.ArrayList<>();
        tmpList3.addAll(((CollectSimplifyExp)left).collect());
        tmpList3.addAll(((CollectSimplifyExp)right).collect());
        return tmpList3;
    }
}
