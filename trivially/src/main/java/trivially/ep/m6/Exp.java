package trivially.ep.m6;

public interface Exp<V> extends trivially.ep.m5.Exp<V> {

    public abstract Boolean equals(trivially.ep.Exp<V> other);

    public abstract trivially.ep.m6.Exp<V> simplify();

    public abstract trivially.ep.m6.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m6.Exp<V> neg(trivially.ep.Exp<V> inner);

    public abstract trivially.ep.m6.Exp<V> mult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m6.Exp<V> divd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m6.Exp<V> lit(Double value);

    public abstract trivially.ep.m6.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.m6.Exp<V> convert(trivially.ep.Exp<V> other);
}
