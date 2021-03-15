package ev.ep;

public class MultBy implements VisitorDivdMultNeg<Exp> {

    protected Exp other;

    public MultBy(Exp _other) {
        this.other = _other;
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

    public Exp visit(Sub exp) {
        return new Sub(exp.getLeft().<Exp>accept(this.makeMultBy(this.other)), exp.getRight().<Exp>accept(this.makeMultBy(this.other)));
    }

    public Exp visit(Lit exp) {
        Exp result = this.other;
        Double counter = Math.floor(Math.abs(exp.getValue()));
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
        return new Add(exp.getLeft().<Exp>accept(this.makeMultBy(this.other)), exp.getRight().<Exp>accept(this.makeMultBy(this.other)));
    }

    public EvalDivdMultNeg makeEval() {
        return new EvalDivdMultNeg();
    }

    public ev.ep.MultBy makeMultBy(Exp _other) {
        return new ev.ep.MultBy(_other);
    }
}
