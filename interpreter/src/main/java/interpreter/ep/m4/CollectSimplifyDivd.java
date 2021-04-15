package interpreter.ep.m4;

import interpreter.ep.m3.PrettypDivd;

public class CollectSimplifyDivd extends PrettypDivd implements CollectSimplifyExp {

    public CollectSimplifyDivd(CollectSimplifyExp left, CollectSimplifyExp right) {
        super(left, right);
    }

	public void truncate (int level) {
		if (level > 1) {
            ((CollectSimplifyExp)left).truncate(level-1);
            ((CollectSimplifyExp)right).truncate(level-1);
		} else {
			left = new CollectSimplifyLit(left.eval());
			right = new CollectSimplifyLit(right.eval());
		}
	}
    
    public CollectSimplifyExp simplify() {
        double leftVal = left.eval();
        double rightVal = right.eval();
        if (leftVal == 0) {
            return new CollectSimplifyLit(0.0);
        } else if (rightVal == 1) {
            return ((CollectSimplifyExp)left).simplify();
        } else if (leftVal == rightVal) {
            return new CollectSimplifyLit(1.0);
        } else if (leftVal == -rightVal) {
            return new CollectSimplifyLit(-1.0);
        } else {
            return new CollectSimplifyDivd (((CollectSimplifyExp)left).simplify(), ((CollectSimplifyExp)right).simplify());
        }
    }

    public java.util.List<Double> collect() {
        java.util.List<Double> tmpList4 = new java.util.ArrayList<>();
        tmpList4.addAll(((CollectSimplifyExp)left).collect());
        tmpList4.addAll(((CollectSimplifyExp)right).collect());
        return tmpList4;
    }
}
