package ev.ep.m7i2;

import ev.ep.i2.Power;
import ev.ep.m3.EvalDivdMultNeg;

/** Extend branch with most work completed and then replicate smaller one. */
public class EvalMerged extends EvalDivdMultNeg implements VisitorMerged<Double> {

    public EvalMerged() { }

    /** Duplicated domain logic. */
    public Double visit(Power exp) {
        return Math.pow(exp.getLeft().<Double>accept(this), exp.getRight().<Double>accept(this));
    }
}
