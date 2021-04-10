package ev.ep.m0;

import ev.ep.Visitor;

public class Eval implements Visitor<Double> {

    public Eval() {
    }

    public Double visit(Lit exp) {
        return exp.getValue();
    }

    public Double visit(Add exp) {
        return exp.getLeft().<Double>accept(this.makeEval()) + exp.getRight().<Double>accept(this.makeEval());
    }

    public Eval makeEval() {
        return new Eval();
    }
}
