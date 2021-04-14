package ev.ep.m1;

import ev.ep.m0.Add;
import ev.ep.m0.Lit;

public class EvalSub extends ev.ep.m0.Eval implements VisitorSub<Double> {

    public EvalSub() {
    }

    public Double visit(Sub exp) {
        return exp.getLeft().<Double>accept(this) - exp.getRight().<Double>accept(this);
    }
//
//    public Double visit(Lit exp) {
//        return exp.getValue();
//    }
//
//    public Double visit(Add exp) {
//        return exp.getLeft().<Double>accept(this) + exp.getRight().<Double>accept(this);
//    }

//    public EvalSub makeEval() {
//        return new EvalSub();
//    }
}
