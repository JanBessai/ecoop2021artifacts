package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.i2.EvalPower;

public class MultByPower implements VisitorMerged<Exp> {

    protected Exp other;

    public MultByPower(Exp _other) {
        this.other = _other;
    }

    public Exp visit(Power exp) {
        return new Power(exp.getLeft(), new Add(exp.getRight(), new Lit(Math.log(2.718281828459045) / Math.log(exp.getRight().<Double>accept(this.makeEval())) / Math.log(2.718281828459045) / Math.log(exp.getLeft().<Double>accept(this.makeEval())))));
    }

    public Exp visit(Neg exp) {
        return new Mult(exp, this.other);
    }
    public Exp visit(Mult exp) {
        return new Mult(exp, this.other);
    }
    public Exp visit(Divd exp) {
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.i2.Power exp) {
        return new Power(exp.getLeft(), new Add(exp.getRight(), new Lit(Math.log(2.718281828459045) / Math.log(exp.getRight().<Double>accept(this.makeEval())) / Math.log(2.718281828459045) / Math.log(exp.getLeft().<Double>accept(this.makeEval())))));
    }

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
        return new Add(exp.getLeft().accept(this.makeMultBy(this.other)), exp.getRight().accept(this.makeMultBy(this.other)));
    }

    public EvalPower makeEval() {
        return new EvalPower();
    }

    public MultByPower makeMultBy(Exp _other) {
        return new MultByPower(_other);
    }

    @Override
    public Exp visit(ev.ep.m0.Lit exp) {
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.m0.Add exp){
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.m1.Sub exp) {
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.m3.Neg exp) {
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.m3.Mult exp){
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.m3.Divd exp) {
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.m4.Lit exp){
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.m4.Add exp){
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.m4.Sub exp) {
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.m4.Neg exp){
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.m4.Mult exp) {
        return new Mult(exp, this.other);
    }

    @Override
    public Exp visit(ev.ep.m4.Divd exp) {
        return new Mult(exp, this.other);
    }
}
