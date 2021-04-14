package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.m4.Truncate;

/**
 * Truncate does not play well with earlier instances, since there is no
 * setLeft() and setRight() for these data types until they are introduced.
 *
 * Since this operation has a side-effect, the solution opts to provide a
 * veneer to satisfy the compiler, but it will throw runtime exceptions
 * if the new operation is invoked on an earlier data type.
 */
public class TruncateMerged extends Truncate implements VisitorMerged<Exp> {
    public TruncateMerged(int level) {
        super(level);
    }

    @Override
    public Exp visit(ev.ep.i2.Power exp) {
        if (level > 1) {
            exp.getLeft().accept(this.makeTruncate(level-1));
            exp.getRight().accept(this.makeTruncate(level-1));
        } else {
            exp.setLeft(new ev.ep.m0.Lit(exp.getLeft().accept(this.makeEval())));
            exp.setRight(new ev.ep.m0.Lit(exp.getRight().accept(this.makeEval())));
        }

        return exp;
    }

    public EvalMerged makeEval() {
        return new EvalMerged();
    }

    public TruncateMerged makeTruncate(int level) {
        return new TruncateMerged(level);
    }


}
