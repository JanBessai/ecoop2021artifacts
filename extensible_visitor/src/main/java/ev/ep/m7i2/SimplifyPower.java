package ev.ep.m7i2;

import ev.ep.Exp;

// Duplication of operation logic
public class SimplifyPower implements VisitorMerged<Exp> {

    public SimplifyPower() { }

    public Exp visit(ev.ep.m7i2.Lit exp) { return exp; }
    public Exp visit(ev.ep.m4.Lit exp) { return exp; }
    public Exp visit(ev.ep.m0.Lit exp) { return exp; }

    public Exp visit(ev.ep.m7i2.Power exp) {
        if (exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m7i2.Lit(1.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(1.0)) {
            return new ev.ep.m7i2.Lit(1.0);
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else {
            return new ev.ep.m7i2.Power(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }
    public Exp visit(ev.ep.i2.Power exp) {
        if (exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m7i2.Lit(1.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(1.0)) {
            return new ev.ep.m7i2.Lit(1.0);
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else {
            return new ev.ep.m7i2.Power(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }

    public Exp visit(ev.ep.m7i2.Add exp) {
        if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval()) + exp.getRight().<Double>accept(this.makeEval())).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0)) {
            return exp.getRight().accept(this.makeSimplify());
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else {
            return new ev.ep.m7i2.Add(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }
    public Exp visit(ev.ep.m4.Add exp) {
        if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval()) + exp.getRight().<Double>accept(this.makeEval())).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0)) {
            return exp.getRight().accept(this.makeSimplify());
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else {
            return new ev.ep.m7i2.Add(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }
    public Exp visit(ev.ep.m0.Add exp) {
        if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval()) + exp.getRight().<Double>accept(this.makeEval())).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0)) {
            return exp.getRight().accept(this.makeSimplify());
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else {
            return new ev.ep.m7i2.Add(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }

    public Exp visit(ev.ep.m7i2.Sub exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new ev.ep.m7i2.Lit(0.0);
        } else {
            return new ev.ep.m7i2.Sub(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }
    public Exp visit(ev.ep.m4.Sub exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new ev.ep.m7i2.Lit(0.0);
        } else {
            return new ev.ep.m7i2.Sub(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }
    public Exp visit(ev.ep.m1.Sub exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new ev.ep.m7i2.Lit(0.0);
        } else {
            return new ev.ep.m7i2.Sub(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }

    public Exp visit(ev.ep.m7i2.Mult exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0) || exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getRight().accept(this.makeSimplify());
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else {
            return new ev.ep.m7i2.Mult(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }
    public Exp visit(ev.ep.m4.Mult exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0) || exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getRight().accept(this.makeSimplify());
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else {
            return new ev.ep.m7i2.Mult(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }
    public Exp visit(ev.ep.m3.Mult exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0) || exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getRight().accept(this.makeSimplify());
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else {
            return new ev.ep.m7i2.Mult(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }

    public Exp visit(ev.ep.m7i2.Neg exp) {
        if (exp.getInner().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else {
            return new ev.ep.m7i2.Neg(exp.getInner().accept(this.makeSimplify()));
        }
    }
    public Exp visit(ev.ep.m4.Neg exp) {
        if (exp.getInner().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else {
            return new ev.ep.m7i2.Neg(exp.getInner().accept(this.makeSimplify()));
        }
    }
    public Exp visit(ev.ep.m3.Neg exp) {
        if (exp.getInner().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else {
            return new ev.ep.m7i2.Neg(exp.getInner().accept(this.makeSimplify()));
        }
    }

    public Exp visit(ev.ep.m7i2.Divd exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new ev.ep.m7i2.Lit(1.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(-1.0 * exp.getRight().<Double>accept(this.makeEval()))) {
            return new ev.ep.m7i2.Lit(-1.0);
        } else {
            return new ev.ep.m7i2.Divd(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }
    public Exp visit(ev.ep.m4.Divd exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new ev.ep.m7i2.Lit(1.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(-1.0 * exp.getRight().<Double>accept(this.makeEval()))) {
            return new ev.ep.m7i2.Lit(-1.0);
        } else {
            return new ev.ep.m7i2.Divd(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }
    public Exp visit(ev.ep.m3.Divd exp) {
        if (exp.getLeft().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m7i2.Lit(0.0);
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new ev.ep.m7i2.Lit(1.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(-1.0 * exp.getRight().<Double>accept(this.makeEval()))) {
            return new ev.ep.m7i2.Lit(-1.0);
        } else {
            return new ev.ep.m7i2.Divd(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }
    public EvalDivdMultNegTruncateEqualPower makeEval() { return new EvalDivdMultNegTruncateEqualPower(); }
    public SimplifyPower makeSimplify() { return new SimplifyPower(); }

}
