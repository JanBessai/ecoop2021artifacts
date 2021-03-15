package ev.ep;

public class SimplifyPower implements VisitorPower<Exp> {

    public SimplifyPower() {
    }

    public Exp visit(Power exp) {
        if (Double.valueOf(exp.getRight().<Double>accept(this.makeEval())).equals(0.0)) {
            return new Lit(1.0);
        } else if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval())).equals(1.0)) {
            return new Lit(1.0);
        } else {
            return new Power(exp.getLeft().<Exp>accept(this.makeSimplify()), exp.getRight().<Exp>accept(this.makeSimplify()));
        }
    }

    public Exp visit(Neg exp) {
        if (Double.valueOf(exp.getInner().<Double>accept(this.makeEval())).equals(0.0)) {
            return new Lit(0.0);
        } else {
            return new Neg(exp.getInner().<Exp>accept(this.makeSimplify()));
        }
    }

    public Exp visit(Mult exp) {
        if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval())).equals(0.0) || Double.valueOf(exp.getRight().<Double>accept(this.makeEval())).equals(0.0)) {
            return new Lit(0.0);
        } else if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval())).equals(1.0)) {
            return exp.getRight().<Exp>accept(this.makeSimplify());
        } else if (Double.valueOf(exp.getRight().<Double>accept(this.makeEval())).equals(1.0)) {
            return exp.getLeft().<Exp>accept(this.makeSimplify());
        } else {
            return new Mult(exp.getLeft().<Exp>accept(this.makeSimplify()), exp.getRight().<Exp>accept(this.makeSimplify()));
        }
    }

    public Exp visit(Divd exp) {
        if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval())).equals(0.0)) {
            return new Lit(0.0);
        } else if (Double.valueOf(exp.getRight().<Double>accept(this.makeEval())).equals(1.0)) {
            return exp.getLeft().<Exp>accept(this.makeSimplify());
        } else if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval())).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new Lit(1.0);
        } else if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval())).equals(-1.0 * exp.getRight().<Double>accept(this.makeEval()))) {
            return new Lit(-1.0);
        } else {
            return new Divd(exp.getLeft().<Exp>accept(this.makeSimplify()), exp.getRight().<Exp>accept(this.makeSimplify()));
        }
    }

    public Exp visit(Sub exp) {
        if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval())).equals(exp.getRight().<Double>accept(this.makeEval()))) {
            return new Lit(0.0);
        } else {
            return new Sub(exp.getLeft().<Exp>accept(this.makeSimplify()), exp.getRight().<Exp>accept(this.makeSimplify()));
        }
    }

    public Exp visit(Lit exp) {
        return exp;
    }

    public Exp visit(Add exp) {
        if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval()) + exp.getRight().<Double>accept(this.makeEval())).equals(0.0)) {
            return new Lit(0.0);
        } else if (Double.valueOf(exp.getLeft().<Double>accept(this.makeEval())).equals(0.0)) {
            return exp.getRight().<Exp>accept(this.makeSimplify());
        } else if (Double.valueOf(exp.getRight().<Double>accept(this.makeEval())).equals(0.0)) {
            return exp.getLeft().<Exp>accept(this.makeSimplify());
        } else {
            return new Add(exp.getLeft().<Exp>accept(this.makeSimplify()), exp.getRight().<Exp>accept(this.makeSimplify()));
        }
    }

    public EvalPower makeEval() {
        return new EvalPower();
    }

    public ev.ep.SimplifyPower makeSimplify() {
        return new ev.ep.SimplifyPower();
    }
}
