package ev.ep.m7i2;

import ev.ep.m4.Truncate;

public class TruncateMerged extends Truncate implements VisitorMerged<Void> {
    public TruncateMerged(int level) {
        super(level);
    }

    @Override
    public Void visit(ev.ep.i2.Power exp) {
        if (level > 1) {
            exp.getLeft().accept(this.makeTruncate(level-1));
            exp.getRight().accept(this.makeTruncate(level-1));
        } else {
            exp.setLeft(new ev.ep.m0.Lit(exp.getLeft().accept(this.makeEval())));
            exp.setRight(new ev.ep.m0.Lit(exp.getRight().accept(this.makeEval())));
        }

        return null;
    }

    public EvalMerged makeEval() {
        return new EvalMerged();
    }

    public TruncateMerged makeTruncate(int level) {
        return new TruncateMerged(level);
    }
}
