package vita.ep.m3;

public abstract interface Lit<V> extends vita.ep.m2.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default String prettyp() {
        return vita.ep.m2.Lit.super.prettyp();
    }

    public default Double eval() {
        return vita.ep.m2.Lit.super.eval();
    }
}
