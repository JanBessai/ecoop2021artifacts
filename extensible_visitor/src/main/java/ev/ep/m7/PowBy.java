package ev.ep.m7;

import ev.ep.Exp;
import ev.ep.m6.*;
import ev.ep.m6.VisitorDivdMultNegTruncateEqual;

public class PowBy implements VisitorDivdMultNegTruncateEqual<Exp> {

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
        return new Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other));
    }
    public Exp visit(ev.ep.m1.Sub exp) {
        return new Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other));
    }
    public Exp visit(ev.ep.m3.Mult exp) {
        return new Mult(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other)));
    }
    public Exp visit(ev.ep.m3.Divd exp) {
        return new Divd(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other)));
    }

    public Exp visit(ev.ep.m3.Neg exp) {
        return new Mult(new Lit(1.0).accept(this.makePowBy(exp.getInner())), exp.getInner().accept(this.makePowBy(this.other)));
    }

    public Exp visit(ev.ep.m4.Lit exp) {
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
    public Exp visit(ev.ep.m4.Add exp) {
        return new Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other));
    }
    public Exp visit(ev.ep.m4.Sub exp) {
        return new Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other));
    }
    public Exp visit(ev.ep.m4.Mult exp) {
        return new Mult(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other)));
    }
    public Exp visit(ev.ep.m4.Divd exp) {
        return new Divd(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other)));
    }
    public Exp visit(ev.ep.m4.Neg exp) {
        return new Mult(new Lit(1.0).accept(this.makePowBy(exp.getInner())), exp.getInner().accept(this.makePowBy(this.other)));
    }

    public Exp visit(Neg exp) {
        return new Mult(new Lit(1.0).accept(this.makePowBy(exp.getInner())), exp.getInner().accept(this.makePowBy(this.other)));
    }

    public Exp visit(Mult exp) {
        return new Mult(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other)));
    }

    public Exp visit(Divd exp) {
        return new Divd(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other)));
    }

    public Exp visit(Sub exp) {
        return new Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other));
    }

    public Exp visit(Lit exp) {
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

    public Exp visit(Add exp) {
        return new Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other));
    }

    public EvalDivdMultNegTruncateEqual makeEval() {
        return new EvalDivdMultNegTruncateEqual();
    }

    public PowBy makePowBy(Exp _other) {
        return new PowBy(_other);
    }
}
