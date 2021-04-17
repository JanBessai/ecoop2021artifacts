package ev.ep.m4;

import ev.ep.Exp;
import ev.ep.m3.EvalDivdMultNeg;
import ev.ep.m3.VisitorDivdMultNeg;
import ev.ep.m0.Lit;
import ev.ep.m0.Add;
import ev.ep.m1.Sub;
import ev.ep.m3.Mult;
import ev.ep.m3.Neg;
import ev.ep.m3.Divd;

public class Simplify implements VisitorDivdMultNeg<Exp> {

    public Simplify() { }

    public Exp visit(ev.ep.m0.Lit exp) {
        return exp;
    }

    public Exp visit(ev.ep.m0.Add exp) {
        if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval()) + exp.getRight().<Double>accept(this.makeEval())).equals(0.0)) {
            return new Lit(0.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0)) {
            return exp.getRight().accept(this);
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return exp.getLeft().accept(this);
        } else {
            return new Add(exp.getLeft().accept(this), exp.getRight().accept(this));
        }
    }

    public Exp visit(ev.ep.m1.Sub exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new Lit(0.0);
        } else {
            return new Sub(exp.getLeft().accept(this), exp.getRight().accept(this));
        }
    }

    public Exp visit(ev.ep.m3.Mult exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0) || exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return new Lit(0.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getRight().accept(this);
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this);
        } else {
            return new Mult(exp.getLeft().accept(this), exp.getRight().accept(this));
        }
    }

    public Exp visit(ev.ep.m3.Neg exp) {
        if (exp.getInner().<Double>accept(this.makeEval()).equals(0.0)) {
            return new Lit(0.0);
        } else {
            return new Neg(exp.getInner().accept(this));
        }
    }

    public Exp visit(ev.ep.m3.Divd exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0)) {
            return new Lit(0.0);
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new Lit(1.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(-1.0 * exp.getRight().<Double>accept(this.makeEval()))) {
            return new Lit(-1.0);
        } else {
            return new Divd(exp.getLeft().accept(this), exp.getRight().accept(this));
        }
    }

    public EvalDivdMultNeg makeEval() {
        return new EvalDivdMultNeg();
    }

}

