package ev.ep.i1;

import ev.ep.m1.EvalSub;
import ev.ep.m1.VisitorSub;
import ev.ep.Exp;
import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.Sub;

public class MultBy implements VisitorSub<Exp> {

    protected Exp other;

    public MultBy(Exp _other) {
        this.other = _other;
    }

    public Exp visit(Sub exp) {
        return new Sub(exp.getLeft().accept(this), exp.getRight().accept(this));
    }

    public Exp visit(Lit exp) {
        Exp result = this.other;
        double counter = Math.floor(Math.abs(exp.getValue()));
        while (1.0 < counter) {
            result = new Add(result, this.other);
            counter = counter - 1.0;
        }
        if (exp.getValue() < 0.0) {
            result = new Sub(new Lit(0.0), result);
        }
        return result;
    }

    public Exp visit(Add exp) {
        return new Add(exp.getLeft().accept(this), exp.getRight().accept(this));
    }

    public EvalSub makeEval() { return new EvalSub(); }
}
