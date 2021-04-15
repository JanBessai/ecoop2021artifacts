package ev.ep.m1;

public class EvalSub extends ev.ep.m0.Eval implements VisitorSub<Double> {

    public EvalSub() {  }

    public Double visit(Sub exp) {
        return exp.getLeft().<Double>accept(this) - exp.getRight().<Double>accept(this);
    }
}
