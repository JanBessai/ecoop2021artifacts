package trivially.ep.m7;

public interface Mult<V> extends trivially.ep.m6.Mult<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> powby(trivially.ep.Exp<V> other) {
        return this.mult(this.getLeft().powby(this.convert(other)), this.getRight().powby(this.convert(other)));
    }

    default Exp<V> simplify() {
        return this.convert(trivially.ep.m6.Mult.super.simplify());
    }
}
