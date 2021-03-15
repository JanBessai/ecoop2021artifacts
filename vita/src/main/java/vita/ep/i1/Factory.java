package vita.ep.i1;

import vita.ep.Exp;

public interface Factory<V> extends vita.ep.m2.Factory<V> {

    public abstract vita.ep.i1.Exp<V> sub(Exp<V> left, Exp<V> right);

    public abstract vita.ep.i1.Exp<V> lit(Double value);

    public abstract vita.ep.i1.Exp<V> add(Exp<V> left, Exp<V> right);

    public abstract vita.ep.i1.Exp<V> convert(Exp<V> other);
}
