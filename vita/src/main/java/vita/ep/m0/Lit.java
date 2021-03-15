package vita.ep.m0;

public abstract interface Lit<V> extends Exp<V> {

    public abstract Double getValue();

    public default Double eval() {
        return this.getValue();
    }
}
