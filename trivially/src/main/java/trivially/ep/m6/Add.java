package trivially.ep.m6;

public abstract interface Add<V> extends trivially.ep.m5.Add<V>, Exp<V> {

    public abstract Exp<V> getLeft();

    public abstract Exp<V> getRight();

    public default Boolean equals(trivially.ep.Exp<V> other) {
        return this.astree().equals(this.convert(other).astree());
    }

    public default Exp<V> simplify() {
        return this.convert(trivially.ep.m5.Add.super.simplify());
    }
}
