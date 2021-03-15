package vita.ep.m5.finalized;

import vita.ep.m5.Exp;

public class Lit extends Factory implements vita.ep.m5.Lit<Visitor> {

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

    public Exp<Visitor> convert(vita.ep.Exp<Visitor> other) {
        Visitor visitor = new Visitor();
        other.accept(visitor);
        return visitor.getResult();
    }
}
