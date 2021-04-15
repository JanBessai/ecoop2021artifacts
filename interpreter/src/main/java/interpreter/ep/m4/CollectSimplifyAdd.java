package interpreter.ep.m4;

import interpreter.ep.m2.PrettypAdd;

public class CollectSimplifyAdd extends PrettypAdd implements CollectSimplifyExp {

    public CollectSimplifyAdd(CollectSimplifyExp left, CollectSimplifyExp right) {
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
        if ((leftVal == 0 && rightVal == 0) || (leftVal + rightVal == 0)) {
            return new CollectSimplifyLit(0.0);
        } else if (leftVal == 0) {
            return ((CollectSimplifyExp)right).simplify();
        } else if (rightVal == 0) {
            return ((CollectSimplifyExp)left).simplify();
        } else {
            return new CollectSimplifyAdd(((CollectSimplifyExp)left).simplify(), ((CollectSimplifyExp)right).simplify());
        }
    }

    public java.util.List<Double> collect() {
        java.util.List<Double> tmpList7 = new java.util.ArrayList<>();
        tmpList7.addAll(((CollectSimplifyExp)left).collect());
        tmpList7.addAll(((CollectSimplifyExp)right).collect());
        return tmpList7;
    }
}
