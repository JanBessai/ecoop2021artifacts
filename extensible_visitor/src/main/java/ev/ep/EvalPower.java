package ev.ep;

public class EvalPower implements VisitorPower<Double> {

    public EvalPower() {
    }

    public Double visit(Power exp) {
        return Math.pow(exp.getLeft().<Double>accept(this.makeEval()), exp.getRight().<Double>accept(this.makeEval()));
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

    public ev.ep.EvalPower makeEval() {
        return new ev.ep.EvalPower();
    }
}
