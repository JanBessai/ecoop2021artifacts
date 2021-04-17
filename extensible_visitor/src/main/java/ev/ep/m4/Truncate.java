package ev.ep.m4;

import ev.ep.m3.EvalDivdMultNeg;
import ev.ep.m3.VisitorDivdMultNeg;
import ev.ep.m0.Lit;
import ev.ep.m0.Add;
import ev.ep.m1.Sub;
import ev.ep.m3.Mult;
import ev.ep.m3.Neg;
import ev.ep.m3.Divd;

public class Truncate implements VisitorDivdMultNeg<Void> {
    protected int level;

    public Truncate(int level) {
        this.level = level;
    }

    public Void visit(Neg exp) {
        if (level > 1) {
            exp.getInner().accept(this.makeTruncate(level-1));
        } else {
            exp.setInner(new Lit(exp.getInner().accept(this.makeEval())));
        }
        return null;
    }

    public Void visit(Mult exp) {
        if (level > 1) {
            exp.getLeft().accept(this.makeTruncate(level-1));
            exp.getRight().accept(this.makeTruncate(level-1));
        } else {
            exp.setLeft(new Lit(exp.getLeft().accept(this.makeEval())));
            exp.setRight(new Lit(exp.getRight().accept(this.makeEval())));
        }
        return null;
    }

    public Void visit(Divd exp) {
        if (level > 1) {
            exp.getLeft().accept(this.makeTruncate(level-1));
            exp.getRight().accept(this.makeTruncate(level-1));
        } else {
            exp.setLeft(new Lit(exp.getLeft().accept(this.makeEval())));
            exp.setRight(new Lit(exp.getRight().accept(this.makeEval())));
        }
        return null;
    }

    public Void visit(Sub exp) {
        if (level > 1) {
            exp.getLeft().accept(this.makeTruncate(level-1));
            exp.getRight().accept(this.makeTruncate(level-1));
        } else {
            exp.setLeft(new Lit(exp.getLeft().accept(this.makeEval())));
            exp.setRight(new Lit(exp.getRight().accept(this.makeEval())));
        }
        return null;
    }

    public Void visit(Lit exp) {
        return null;
    }

    public Void visit(Add exp) {
        if (level > 1) {
            exp.getLeft().accept(this.makeTruncate(level-1));
            exp.getRight().accept(this.makeTruncate(level-1));
        } else {
            exp.setLeft(new Lit(exp.getLeft().accept(this.makeEval())));
            exp.setRight(new Lit(exp.getRight().accept(this.makeEval())));
        }
        return null;
    }

    public EvalDivdMultNeg makeEval() {
        return new EvalDivdMultNeg();
    }

    public Truncate makeTruncate(int level) {
        return new Truncate(level);
    }
}
