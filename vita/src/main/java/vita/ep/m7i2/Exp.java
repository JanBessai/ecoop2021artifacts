package vita.ep.m7i2;

public interface Exp<V> extends vita.ep.m7.Exp<V>, vita.ep.i2.Exp<V>, Factory<V> {

    public abstract vita.ep.m7i2.Exp<V> simplify();

    public abstract vita.ep.m7i2.Exp<V> powby(vita.ep.Exp<V> other);

    public abstract vita.ep.m7i2.Exp<V> multby(vita.ep.Exp<V> other);
}
