package ev.ep;

public class EvalSub implements VisitorSub<Double> {

    public EvalSub() {
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

    public ev.ep.EvalSub makeEval() {
        return new ev.ep.EvalSub();
    }
}
