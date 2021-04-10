package ev.ep.m4;

import ev.ep.Exp;

public class Simplify implements VisitorDivdMultNegTruncate<Exp> {

    public Simplify() {
    }

    // unsafe runtime exceptions
    public Exp visit(ev.ep.m0.Lit exp) {
        return visit((ev.ep.m4.Lit)exp);
    }
    public Exp visit(ev.ep.m0.Add exp) {
        return visit((ev.ep.m4.Add)exp);
    }
    public Exp visit(ev.ep.m1.Sub exp) {
        return visit((ev.ep.m4.Sub)exp);
    }
    public Exp visit(ev.ep.m3.Neg exp) {
        return visit((ev.ep.m4.Neg)exp);
    }
    public Exp visit(ev.ep.m3.Divd exp) {
        return visit((ev.ep.m4.Divd)exp);
    }
    public Exp visit(ev.ep.m3.Mult exp) {
        return visit((ev.ep.m4.Mult)exp);
    }

    public Exp visit(ev.ep.m4.Neg exp) {
        if (exp.getInner().<Double>accept(this.makeEval()).equals(0.0)) {
            return new Lit(0.0);
        } else {
            return new Neg(exp.getInner().accept(this.makeSimplify()));
        }
    }

    public Exp visit(ev.ep.m4.Mult exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0) || exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return new Lit(0.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getRight().accept(this.makeSimplify());
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else {
            return new Mult(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }

    public Exp visit(ev.ep.m4.Divd exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0)) {
            return new Lit(0.0);
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new Lit(1.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(-1.0 * exp.getRight().<Double>accept(this.makeEval()))) {
            return new Lit(-1.0);
        } else {
            return new Divd(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }

    public Exp visit(Sub exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new Lit(0.0);
        } else {
            return new Sub(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }

    public Exp visit(Lit exp) {
        return exp;
    }

    public Exp visit(Add exp) {
        if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval()) + exp.getRight().<Double>accept(this.makeEval())).equals(0.0)) {
            return new Lit(0.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0)) {
            return exp.getRight().accept(this.makeSimplify());
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else {
            return new Add(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }

    public EvalDivdMultNegTruncate makeEval() {
        return new EvalDivdMultNegTruncate();
    }

    public Simplify makeSimplify() {
        return new Simplify();
    }

}

