package ev.ep.m7i2;

public class EvalDivdMultNegTruncateEqualPower implements VisitorMerged<Double> {

    public EvalDivdMultNegTruncateEqualPower() { }

    public Double visit(ev.ep.m7i2.Neg exp) { return -1.0 * exp.getInner().<Double>accept(this.makeEval()); }
    public Double visit(ev.ep.m4.Neg exp) { return -1.0 * exp.getInner().<Double>accept(this.makeEval()); }
    public Double visit(ev.ep.m3.Neg exp) { return -1.0 * exp.getInner().<Double>accept(this.makeEval()); }

    Double visitAdd(double left, double right) {
        return left + right;
    }

    Double visitSub(double left, double right) {
        return left - right;
    }

    Double visitMult(double left, double right) {
        return left * right;
    }

    Double visitDivd(double left, double right) {
        return left / right;
    }

    Double visitPower(double left, double right) {
        return Math.pow(left, right);
    }

    public Double visit(ev.ep.m7i2.Mult exp) {
        return visitMult(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
    }
    public Double visit(ev.ep.m4.Mult exp) {
        return visitMult(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
    }
    public Double visit(ev.ep.m3.Mult exp) {
        return visitMult(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
    }

    public Double visit(ev.ep.m7i2.Divd exp) {
        return visitDivd(exp.getLeft().<Double>accept(this.makeEval()) , exp.getRight().<Double>accept(this.makeEval()));
    }
    public Double visit(ev.ep.m4.Divd exp) {
        return visitDivd(exp.getLeft().<Double>accept(this.makeEval()) , exp.getRight().<Double>accept(this.makeEval()));
    }
    public Double visit(ev.ep.m3.Divd exp) {
        return visitDivd(exp.getLeft().<Double>accept(this.makeEval()) , exp.getRight().<Double>accept(this.makeEval()));
    }

    public Double visit(ev.ep.m7i2.Sub exp) {
        return visitSub(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
    }
    public Double visit(ev.ep.m4.Sub exp) {
        return visitSub(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
    }
    public Double visit(ev.ep.m1.Sub exp) {
        return visitSub(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
    }

    public Double visit(ev.ep.m7i2.Lit exp) {
        return exp.getValue();
    }
    public Double visit(ev.ep.m4.Lit exp) {
        return exp.getValue();
    }
    public Double visit(ev.ep.m0.Lit exp) {
        return exp.getValue();
    }

    public Double visit(ev.ep.m7i2.Add exp) {
        return visitAdd(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
    }
    public Double visit(ev.ep.m4.Add exp) {
        return visitAdd(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
    }
    public Double visit(ev.ep.m0.Add exp) {
        return visitAdd(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
    }

    public Double visit(ev.ep.m7i2.Power exp) {
        return visitPower(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
    }
    public Double visit(ev.ep.i2.Power exp) {
        return visitPower(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
    }


    public EvalDivdMultNegTruncateEqualPower makeEval() { return new EvalDivdMultNegTruncateEqualPower(); }

}
