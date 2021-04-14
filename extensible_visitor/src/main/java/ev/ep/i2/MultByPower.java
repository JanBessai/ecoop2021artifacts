package ev.ep.i2;

import ev.ep.Exp;
import ev.ep.i1.MultBy;
import ev.ep.m0.Add;
import ev.ep.m0.Lit;

public class MultByPower extends MultBy implements VisitorPower<Exp> {

    public MultByPower(Exp _other) { super(_other); }

    @Override
    public Exp visit(Power exp) {
        double leftEval = exp.getLeft().accept(makeEval());
        double added = Math.log(other.accept(makeEval())) / Math.log(leftEval);
        return new Power(exp.getLeft(), new Add(exp.getRight(), new Lit(added)));
    }

    public EvalPower makeEval() { return new EvalPower(); }
}
