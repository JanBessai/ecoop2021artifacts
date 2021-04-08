package trivially.ep.m6;

public interface Neg<V> extends trivially.ep.m5.Neg<V>, Exp<V> {

    Exp<V> getInner();

    default Boolean equals(trivially.ep.Exp<V> other) {
        return this.astree().equals(convert(other).astree());
    }

    @Override
    default Boolean isNeg(trivially.ep.Exp<V> inner) {
        return convert(inner).eql(getInner());
    }

    default Boolean eql(trivially.ep.Exp<V> that) {
        return convert(that).isNeg(getInner());
    }

    default Exp<V> simplify() {
        return convert(trivially.ep.m5.Neg.super.simplify());
    }
}
