package trivially.ep.m7;

public interface Add<V> extends trivially.ep.m6.Add<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.lit(this.eval()).powby(this.convert(other));
    }

    default Exp<V> simplify() {
        return this.convert(trivially.ep.m6.Add.super.simplify());
    }
}
