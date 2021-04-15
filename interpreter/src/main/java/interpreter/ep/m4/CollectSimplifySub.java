package interpreter.ep.m4;

import interpreter.ep.m2.PrettypSub;

public class CollectSimplifySub extends PrettypSub implements CollectSimplifyExp {

    public CollectSimplifySub(CollectSimplifyExp left, CollectSimplifyExp right) {
        super(left, right);
    }

    public CollectSimplifyExp simplify() {
        if (left.eval().equals(right.eval())) {
            return new CollectSimplifyLit(0.0);
        } else {
            return new CollectSimplifySub (((CollectSimplifyExp)left).simplify(), ((CollectSimplifyExp)right).simplify());
        }
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

    public java.util.List<Double> collect() {
        java.util.List<Double> tmpList5 = new java.util.ArrayList<>();
        tmpList5.addAll(((CollectSimplifyExp)left).collect());
        tmpList5.addAll(((CollectSimplifyExp)right).collect());
        return tmpList5;
    }
}
