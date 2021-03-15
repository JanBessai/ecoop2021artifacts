package trivially.ep.m1;

public interface Exp<V> extends trivially.ep.m0.Exp<V> {

    public abstract trivially.ep.m1.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m1.Exp<V> lit(Double value);

    public abstract trivially.ep.m1.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m1.Exp<V> convert(trivially.ep.Exp<V> other);
}
