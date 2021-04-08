package trivially.ep.m7i2;

public interface Neg<V> extends trivially.ep.m7.Neg<V>, Exp<V> {

    Exp<V> getInner();

    default Exp<V> simplify() {
        return this.convert(trivially.ep.m7.Neg.super.simplify());
    }

    default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.mult(this, convert(other));
    }

    default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.power(this, convert(other));
    }
}
