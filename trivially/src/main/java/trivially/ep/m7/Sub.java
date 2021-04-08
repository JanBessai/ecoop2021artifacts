package trivially.ep.m7;

public interface Sub<V> extends trivially.ep.m6.Sub<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.lit(this.eval()).powby(convert(other));
    }

    default Exp<V> simplify() {
        return convert(trivially.ep.m6.Sub.super.simplify());
    }

}
