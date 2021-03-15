package trivially.ep.i1;

public interface Exp<V> extends trivially.ep.m6.Exp<V> {

    public abstract trivially.ep.i1.Exp<V> multby(trivially.ep.Exp<V> other);

    public abstract trivially.ep.i1.Exp<V> simplify();

    public abstract trivially.ep.i1.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.i1.Exp<V> neg(trivially.ep.Exp<V> inner);

    public abstract trivially.ep.i1.Exp<V> mult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.i1.Exp<V> divd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.i1.Exp<V> lit(Double value);

    public abstract trivially.ep.i1.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    public abstract trivially.ep.i1.Exp<V> convert(trivially.ep.Exp<V> other);
}
