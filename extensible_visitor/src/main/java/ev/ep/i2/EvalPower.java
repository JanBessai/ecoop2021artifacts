package ev.ep.i2;

import ev.ep.m1.EvalSub;

public class EvalPower extends EvalSub implements VisitorPower<Double> {

    public EvalPower() {
    }

    public Double visit(Power exp) {
        return Math.pow(exp.getLeft().<Double>accept(this), exp.getRight().<Double>accept(this));
    }
}
