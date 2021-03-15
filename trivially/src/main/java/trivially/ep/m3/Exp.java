package trivially.ep.m3;

public interface Exp<V> extends trivially.ep.m2.Exp<V> {

    public abstract trivially.ep.m3.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m3.Exp<V> neg(trivially.ep.Exp<V> inner);

    public abstract trivially.ep.m3.Exp<V> mult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m3.Exp<V> divd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m3.Exp<V> lit(Double value);

    public abstract trivially.ep.m3.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m3.Exp<V> convert(trivially.ep.Exp<V> other);
}
