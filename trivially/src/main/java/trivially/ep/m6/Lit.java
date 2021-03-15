package trivially.ep.m6;

public abstract interface Lit<V> extends trivially.ep.m5.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default Boolean equals(trivially.ep.Exp<V> other) {
        return this.astree().equals(this.convert(other).astree());
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m5.Lit.super.simplify());
    }
}
