package vita.ep.i1.finalized;

import vita.ep.Exp;

public class Factory implements vita.ep.i1.Factory<Visitor> {

    public vita.ep.i1.Exp<Visitor> sub(Exp<Visitor> left, Exp<Visitor> right) {
        return new Sub(this.convert(left), this.convert(right));
    }

    public vita.ep.i1.Exp<Visitor> lit(Double value) {
        return new Lit(value);
    }

    public vita.ep.i1.Exp<Visitor> add(Exp<Visitor> left, Exp<Visitor> right) {
        return new Add(this.convert(left), this.convert(right));
    }

    public vita.ep.i1.Exp<Visitor> convert(Exp<Visitor> other) {
        Visitor visitor = new Visitor();
        other.accept(visitor);
        return visitor.getResult();
    }
}
