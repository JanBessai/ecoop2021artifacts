package ev.ep.m4;

import ev.ep.Exp;

/**
 * Truncate does not play well with earlier instances, since there is no
 * setLeft() and setRight() for these data types until they are introduced.
 *
 * Since this operation has a side-effect, the solution opts to provide a
 * veneer to satisfy the compiler, but it will throw runtime exceptions
 * if the new operation is invoked on an earlier data type.
 */
public class Truncate implements VisitorDivdMultNegTruncate<Exp> {
    int level;

    // Might be unsafe, if invoked using objects from older evolution branch.
    public Exp visit(ev.ep.m0.Lit exp) { return visit((ev.ep.m4.Lit)exp); }
    public Exp visit(ev.ep.m0.Add exp) { return visit((ev.ep.m4.Add)exp); }
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

    public Truncate(int level) {
        this.level = level;
    }

    public Exp visit(Neg exp) {
        if (level > 1) {
            exp.getInner().accept(this.makeTruncate(level-1));
        } else {
            exp.setInner(new Lit(exp.getInner().accept(this.makeEval())));
        }

        return exp;
    }

    public Exp visit(Mult exp) {
        if (level > 1) {
            exp.getLeft().accept(this.makeTruncate(level-1));
            exp.getRight().accept(this.makeTruncate(level-1));
        } else {
            exp.setLeft(new Lit(exp.getLeft().accept(this.makeEval())));
            exp.setRight(new Lit(exp.getRight().accept(this.makeEval())));
        }

        return exp;
    }

    public Exp visit(Divd exp) {
        if (level > 1) {
            exp.getLeft().accept(this.makeTruncate(level-1));
            exp.getRight().accept(this.makeTruncate(level-1));
        } else {
            exp.setLeft(new Lit(exp.getLeft().accept(this.makeEval())));
            exp.setRight(new Lit(exp.getRight().accept(this.makeEval())));
        }

        return exp;
    }

    public Exp visit(Sub exp) {
        if (level > 1) {
            exp.getLeft().accept(this.makeTruncate(level-1));
            exp.getRight().accept(this.makeTruncate(level-1));
        } else {
            exp.setLeft(new Lit(exp.getLeft().accept(this.makeEval())));
            exp.setRight(new Lit(exp.getRight().accept(this.makeEval())));
        }

        return exp;
    }

    public Exp visit(Lit exp) {
        return exp;
    }

    public Exp visit(Add exp) {
        if (level > 1) {
            exp.getLeft().accept(this.makeTruncate(level-1));
            exp.getRight().accept(this.makeTruncate(level-1));
        } else {
            exp.setLeft(new Lit(exp.getLeft().accept(this.makeEval())));
            exp.setRight(new Lit(exp.getRight().accept(this.makeEval())));
        }

        return exp;
    }

    public EvalDivdMultNegTruncate makeEval() {
        return new EvalDivdMultNegTruncate();
    }

    public Truncate makeTruncate(int level) {
        return new Truncate(level);
    }


}
