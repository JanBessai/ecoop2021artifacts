package ev.ep.m0;

public class Eval implements VisitorAddLit<Double> {

    public Eval() {
    }

    public Double visit(Lit exp) {
        return exp.getValue();
    }

    public Double visit(Add exp) {
        return exp.getLeft().<Double>accept(this) + exp.getRight().<Double>accept(this);
    }
}
