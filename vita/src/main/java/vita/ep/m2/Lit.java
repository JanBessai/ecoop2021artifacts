package vita.ep.m2;

public abstract interface Lit<V> extends vita.ep.m1.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default String prettyp() {
        return String.valueOf(this.getValue());
    }

    public default Double eval() {
        return vita.ep.m1.Lit.super.eval();
    }
}
