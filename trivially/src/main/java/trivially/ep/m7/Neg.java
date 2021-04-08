package trivially.ep.m7;

public interface Neg<V> extends trivially.ep.m6.Neg<V>, Exp<V> {

    Exp<V> getInner();

    default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.mult(this.lit(1.0).powby(this.getInner()), this.getInner().powby(convert(other)));
    }

    default Exp<V> simplify() {
        return convert(trivially.ep.m6.Neg.super.simplify());
    }
}
