package vita.ep.i2;

import vita.ep.Exp;

public interface Factory<V> extends vita.ep.i1.Factory<V> {

    public abstract vita.ep.i2.Exp<V> sub(Exp<V> left, Exp<V> right);

    public abstract vita.ep.i2.Exp<V> power(Exp<V> left, Exp<V> right);

    public abstract vita.ep.i2.Exp<V> lit(Double value);

    public abstract vita.ep.i2.Exp<V> add(Exp<V> left, Exp<V> right);

    public abstract vita.ep.i2.Exp<V> convert(Exp<V> other);
}
