package ev.ep.m7i2;

import ev.ep.Exp;

public class PowByPower implements VisitorMerged<Exp> {

    protected Exp other;

    public PowByPower(Exp _other) {
        this.other = _other;
    }

    // in Merged Branch, we can take advantage of Power!
    public Exp visit(ev.ep.m7i2.Lit exp) {
        return new Power(exp, this.other);
    }

    public Exp visit(ev.ep.m4.Lit exp) {
        return new Power(exp, this.other);
    }

    public Exp visit(ev.ep.m0.Lit exp) {
        return new Power(exp, this.other);
    }

    // Add and Sub have to be evaluated to a Lit, which is then raised to the power.
    public Exp visit(ev.ep.m7i2.Add exp) { return new ev.ep.m7i2.Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other)); }
    public Exp visit(ev.ep.m4.Add exp) { return new ev.ep.m7i2.Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other)); }
    public Exp visit(ev.ep.m0.Add exp) { return new ev.ep.m7i2.Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other)); }

    public Exp visit(ev.ep.m7i2.Sub exp) { return new ev.ep.m7i2.Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other)); }
    public Exp visit(ev.ep.m4.Sub exp) { return new ev.ep.m7i2.Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other)); }
    public Exp visit(ev.ep.m1.Sub exp) { return new ev.ep.m7i2.Lit(exp.<Double>accept(this.makeEval())).accept(this.makePowBy(this.other)); }

    // ( - x) ^ y is equal to (-1)^y * x^y
    public Exp visit(ev.ep.m7i2.Neg exp) { return new ev.ep.m7i2.Mult(new ev.ep.m7i2.Lit(-1.0).accept(this.makePowBy(this.other)), exp.getInner().accept(this.makePowBy(this.other))); }
    public Exp visit(ev.ep.m4.Neg exp) { return new ev.ep.m7i2.Mult(new ev.ep.m7i2.Lit(-1.0).accept(this.makePowBy(this.other)), exp.getInner().accept(this.makePowBy(this.other))); }
    public Exp visit(ev.ep.m3.Neg exp) { return new ev.ep.m7i2.Mult(new ev.ep.m7i2.Lit(-1.0).accept(this.makePowBy(this.other)), exp.getInner().accept(this.makePowBy(this.other))); }

    // Mult and Divd can pass through the powBy to its arguments.
    public Exp visit(ev.ep.m7i2.Mult exp) { return new ev.ep.m7i2.Mult(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other))); }
    public Exp visit(ev.ep.m4.Mult exp) { return new ev.ep.m7i2.Mult(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other))); }
    public Exp visit(ev.ep.m3.Mult exp) { return new ev.ep.m7i2.Mult(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other))); }

    public Exp visit(ev.ep.m7i2.Divd exp) { return new Divd(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other))); }
    public Exp visit(ev.ep.m4.Divd exp) { return new Divd(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other))); }
    public Exp visit(ev.ep.m3.Divd exp) { return new Divd(exp.getLeft().accept(this.makePowBy(this.other)), exp.getRight().accept(this.makePowBy(this.other))); }

    public Exp visit( ev.ep.m7i2.Power exp) { return new ev.ep.m7i2.Power(exp, this.other); }
    public Exp visit( ev.ep.i2.Power exp) { return new ev.ep.m7i2.Power(exp, this.other); }

    public EvalDivdMultNegTruncateEqualPower makeEval() { return new EvalDivdMultNegTruncateEqualPower(); }
    public PowByPower makePowBy(Exp _other) { return new PowByPower(_other);}
}
