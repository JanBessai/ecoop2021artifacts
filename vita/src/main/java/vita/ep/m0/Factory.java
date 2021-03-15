package vita.ep.m0;

public interface Factory<V> extends vita.ep.Factory<V> {

    public abstract Exp<V> lit(Double value);

    public abstract Exp<V> add(vita.ep.Exp<V> left, vita.ep.Exp<V> right);

    public abstract Exp<V> convert(vita.ep.Exp<V> other);
}
