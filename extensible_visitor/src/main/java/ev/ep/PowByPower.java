package ev.ep;

public class PowByPower implements VisitorPower<Exp> {

    protected Exp other;

    public PowByPower(Exp _other) {
        this.other = _other;
    }

    public Exp visit(Power exp) {
        return new Power(exp, this.other);
    }

    public Exp visit(Neg exp) {
        return new Mult(new Lit(1.0).<Exp>accept(this.makePowBy(exp.getInner())), exp.getInner().<Exp>accept(this.makePowBy(this.other)));
    }

    public Exp visit(Mult exp) {
        return new Mult(exp.getLeft().<Exp>accept(this.makePowBy(this.other)), exp.getRight().<Exp>accept(this.makePowBy(this.other)));
    }

    public Exp visit(Divd exp) {
        return new Divd(exp.getLeft().<Exp>accept(this.makePowBy(this.other)), exp.getRight().<Exp>accept(this.makePowBy(this.other)));
    }

    public Exp visit(Sub exp) {
        return new Lit(exp.<Double>accept(this.makeEval())).<Exp>accept(this.makePowBy(this.other));
    }

    public Exp visit(Lit exp) {
        Double exponentValue = this.other.<Double>accept(this.makeEval());
        Exp result = exp;
        Double counter = Math.floor(Math.abs(exponentValue));
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
        return new Lit(exp.<Double>accept(this.makeEval())).<Exp>accept(this.makePowBy(this.other));
    }

    public EvalPower makeEval() {
        return new EvalPower();
    }

    public ev.ep.PowByPower makePowBy(Exp _other) {
        return new ev.ep.PowByPower(_other);
    }
}
