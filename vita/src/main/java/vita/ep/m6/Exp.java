package vita.ep.m6;

public interface Exp<V> extends vita.ep.m5.Exp<V>, Factory<V> {

    public abstract Boolean equals(vita.ep.Exp<V> other);

    public abstract vita.ep.m6.Exp<V> simplify();
}
