package trivially.ep.m5.finalized;

import trivially.ep.m5.Exp;

public class Lit implements trivially.ep.m5.Lit<Visitor>, Factory {

    protected double value;

    public Lit(double _value) {
        this.value = _value;
    }

    public Double getValue() {
        return this.value;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Exp<Visitor> convert(trivially.ep.Exp<Visitor> other) {
        Visitor visitor = new Visitor();
        other.accept(visitor);
        return visitor.getResult();
    }
}
