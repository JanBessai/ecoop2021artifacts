package vita.ep.m6;

import vita.ep.Exp;

public interface Factory<V> extends vita.ep.m5.Factory<V> {

    public abstract vita.ep.m6.Exp<V> sub(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m6.Exp<V> neg(Exp<V> inner);

    public abstract vita.ep.m6.Exp<V> mult(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m6.Exp<V> divd(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m6.Exp<V> lit(Double value);

    public abstract vita.ep.m6.Exp<V> add(Exp<V> left, Exp<V> right);

    public abstract vita.ep.m6.Exp<V> convert(Exp<V> other);
}
