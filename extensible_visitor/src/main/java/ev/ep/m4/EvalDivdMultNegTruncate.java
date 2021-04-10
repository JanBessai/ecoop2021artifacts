package ev.ep.m4;

public class EvalDivdMultNegTruncate implements VisitorDivdMultNegTruncate<Double> {

    public EvalDivdMultNegTruncate() {
    }

    // unsafe runtime exceptions
    public Double visit(ev.ep.m0.Lit exp) { return visit((ev.ep.m4.Lit)exp); }
    public Double visit(ev.ep.m0.Add exp) {
        return visit((ev.ep.m4.Add)exp);
    }
    public Double visit(ev.ep.m1.Sub exp) {
        return visit((ev.ep.m4.Sub)exp);
    }
    public Double visit(ev.ep.m3.Neg exp) {
        return visit((ev.ep.m4.Neg)exp);
    }
    public Double visit(ev.ep.m3.Divd exp) {
        return visit((ev.ep.m4.Divd)exp);
    }
    public Double visit(ev.ep.m3.Mult exp) {
        return visit((ev.ep.m4.Mult)exp);
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

    public EvalDivdMultNegTruncate makeEval() {
        return new EvalDivdMultNegTruncate();
    }
}
