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


/**
 * Truncate does not play well with earlier instances, since there is no
 * setLeft() and setRight() for these data types until they are introduced.
 *
 * Since this operation has a side-effect, the solution opts to provide a
 * veneer to satisfy the compiler, but it will throw runtime exceptions
 * if the new operation is invoked on an earlier data type.
 *
 * To support Truncate, each existing data type needs to be subclassed
 * anew to enable setLeft and setRight methods (or setInner)
 */
public class Truncate implements VisitorDivdMultNeg<Exp> {
    protected int level;

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

    public EvalDivdMultNeg makeEval() {
        return new EvalDivdMultNeg();
    }

    public Truncate makeTruncate(int level) {
        return new Truncate(level);
    }
}
