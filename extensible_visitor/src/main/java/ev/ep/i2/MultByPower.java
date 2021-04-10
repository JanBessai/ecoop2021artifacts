package ev.ep.i2;

import ev.ep.Exp;
import ev.ep.i1.MultBy;
import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.EvalSub;
import ev.ep.m1.Sub;

public class MultByPower extends MultBy implements VisitorPower<Exp> {

    public MultByPower(Exp _other) { super(_other); }

    public Exp visit(Sub exp) {
        return new Sub(exp.getLeft().accept(this.makeMultBy(this.other)), exp.getRight().accept(this.makeMultBy(this.other)));
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
        return new Add(exp.getLeft().accept(this.makeMultBy(this.other)), exp.getRight().<Exp>accept(this.makeMultBy(this.other)));
    }

    @Override
    public Exp visit(Power exp) {
        double leftEval = exp.getLeft().accept(makeEval());
        double added = Math.log(other.accept(makeEval())) / Math.log(leftEval);
        return new Power(exp.getLeft(), new Add(exp.getRight(), new Lit(added)));
    }

    public EvalSub makeEval() { return new EvalSub(); }
    public MultByPower makeMultBy(Exp _other) { return new MultByPower(_other); }
}
