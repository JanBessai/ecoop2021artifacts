package vita.ep.m1;

public abstract interface Lit<V> extends vita.ep.m0.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default Double eval() {
        return vita.ep.m0.Lit.super.eval();
    }
}
