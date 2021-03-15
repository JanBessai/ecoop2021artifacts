package ev.ep;

public class EvalDivdMultNeg implements VisitorDivdMultNeg<Double> {

    public EvalDivdMultNeg() {
    }

    public Double visit(Neg exp) {
        return -1.0 * exp.getInner().<Double>accept(this.makeEval());
    }

    public Double visit(Mult exp) {
        return exp.getLeft().<Double>accept(this.makeEval()) * exp.getRight().<Double>accept(this.makeEval());
    }

    public Double visit(Divd exp) {
        return exp.getLeft().<Double>accept(this.makeEval()) / exp.getRight().<Double>accept(this.makeEval());
    }

    public Double visit(Sub exp) {
        return exp.getLeft().<Double>accept(this.makeEval()) - exp.getRight().<Double>accept(this.makeEval());
    }

    public Double visit(Lit exp) {
        return exp.getValue();
    }

    public Double visit(Add exp) {
        return exp.getLeft().<Double>accept(this.makeEval()) + exp.getRight().<Double>accept(this.makeEval());
    }

    public ev.ep.EvalDivdMultNeg makeEval() {
        return new ev.ep.EvalDivdMultNeg();
    }
}
