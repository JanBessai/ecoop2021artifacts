package interpreter.ep.m4;

import interpreter.ep.m3.PrettypNeg;

public class CollectSimplifyNeg extends PrettypNeg implements CollectSimplifyExp {

    public CollectSimplifyNeg(CollectSimplifyExp inner) {
        super(inner);
    }

	public CollectSimplifyExp simplify() {
        if (inner.eval().equals(0.0)) {
            return new CollectSimplifyLit(0.0);
        } else {
            return new CollectSimplifyNeg(((CollectSimplifyExp)inner).simplify());
        }
    }

    public void truncate (int level) {
        if (level > 1) {
            ((CollectSimplifyExp)inner).truncate(level-1);
        } else {
            inner = new CollectSimplifyLit(inner.eval());
        }
    }

    public java.util.List<Double> collect() {
        java.util.List<Double> tmpList2 = new java.util.ArrayList<>();
        tmpList2.addAll(((CollectSimplifyExp)inner).collect());
        return tmpList2;
    }
}
