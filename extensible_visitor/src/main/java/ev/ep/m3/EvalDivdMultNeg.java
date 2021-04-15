package ev.ep.m3;

import ev.ep.m1.EvalSub;

public class EvalDivdMultNeg extends EvalSub implements VisitorDivdMultNeg<Double> {

    public EvalDivdMultNeg() {  }

    public Double visit(Neg exp) {
        return -1.0 * exp.getInner().<Double>accept(this);
    }

    public Double visit(Mult exp) {
        return exp.getLeft().<Double>accept(this) * exp.getRight().<Double>accept(this);
    }

    public Double visit(Divd exp) {
        return exp.getLeft().<Double>accept(this) / exp.getRight().<Double>accept(this);
    }

}
