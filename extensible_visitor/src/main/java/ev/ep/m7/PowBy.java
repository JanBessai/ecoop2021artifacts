package ev.ep.m7;

import ev.ep.Exp;
import ev.ep.m0.Lit;
import ev.ep.m3.Divd;
import ev.ep.m3.EvalDivdMultNeg;
import ev.ep.m3.Mult;
import ev.ep.m3.VisitorDivdMultNeg;

public class PowBy implements VisitorDivdMultNeg<Exp> {

    protected Exp other;

    public PowBy(Exp _other) {
        this.other = _other;
    }

    public Exp visit(ev.ep.m0.Lit exp) {
        Double exponentValue = this.other.<Double>accept(this.makeEval());
        Exp result = exp;
        double counter = Math.floor(Math.abs(exponentValue));
        while (1.0 < counter) {
            result = new Mult(result, exp);
            counter = counter - 1.0;
        }
        if (exp.getValue() < 0.0) {
            result = new Divd(new Lit(1.0), result);
        }
        return result;
    }
    public Exp visit(ev.ep.m0.Add exp) {
        return new Lit(exp.<Double>accept(this.makeEval())).accept(this);
    }
    public Exp visit(ev.ep.m1.Sub exp) {
        return new Lit(exp.<Double>accept(this.makeEval())).accept(this);
    }
    public Exp visit(ev.ep.m3.Mult exp) {
        return new Mult(exp.getLeft().accept(this), exp.getRight().accept(this));
    }

    public Exp visit(ev.ep.m3.Neg exp) {
        return new Mult(new Lit(1.0).accept(this), exp.getInner().accept(this));
    }

    public Exp visit(ev.ep.m3.Divd exp) {
        return new Divd(exp.getLeft().accept(this), exp.getRight().accept(this));
    }

    public EvalDivdMultNeg makeEval() {
        return new EvalDivdMultNeg();
    }
}
