package trivially.ep.m2;

public abstract interface Lit<V> extends trivially.ep.m1.Lit<V>, Exp<V> {

    public abstract Double getValue();

    public default String prettyp() {
        return String.valueOf(this.getValue());
    }
}
