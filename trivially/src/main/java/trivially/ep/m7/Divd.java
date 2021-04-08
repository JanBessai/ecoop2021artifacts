package trivially.ep.m7;

public interface Divd<V> extends trivially.ep.m6.Divd<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.divd(this.getLeft().powby(this.convert(other)), this.getRight().powby(this.convert(other)));
    }

    default Exp<V> simplify() {
        return this.convert(trivially.ep.m6.Divd.super.simplify());
    }
}
