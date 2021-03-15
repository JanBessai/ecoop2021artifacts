package vita.ep.m0.finalized;

import vita.ep.m0.Exp;

public class Factory implements vita.ep.m0.Factory<Visitor> {

    public Exp<Visitor> lit(Double value) {
        return new Lit(value);
    }

    public Exp<Visitor> add(vita.ep.Exp<Visitor> left, vita.ep.Exp<Visitor> right) {
        return new Add(this.convert(left), this.convert(right));
    }

    public Exp<Visitor> convert(vita.ep.Exp<Visitor> other) {
        Visitor visitor = new Visitor();
        other.accept(visitor);
        return visitor.getResult();
    }
}
