package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.m4.Simplify;

/**
 * The simplify() logic within the Power data type needs to be duplicated here,
 * to take advantage of the new visitors defined for the merge.
 */
public class SimplifyMerged extends Simplify implements VisitorMerged<Exp> {

    public SimplifyMerged() { }

    public Exp visit(ev.ep.i2.Power exp) {
        if (exp.getRight().<Double>accept(this.makeEval()).equals(0.0)) {
            return new ev.ep.m0.Lit(1.0);
        } else if (exp.getLeft().<Double>accept(this.makeEval()).equals(1.0)) {
            return new ev.ep.m0.Lit(1.0);
        } else if (exp.getRight().<Double>accept(this.makeEval()).equals(1.0)) {
            return exp.getLeft().accept(this.makeSimplify());
        } else {
            return new ev.ep.i2.Power(exp.getLeft().accept(this.makeSimplify()), exp.getRight().accept(this.makeSimplify()));
        }
    }

    public EvalMerged makeEval() { return new EvalMerged(); }
    public SimplifyMerged makeSimplify() { return new SimplifyMerged(); }
}
