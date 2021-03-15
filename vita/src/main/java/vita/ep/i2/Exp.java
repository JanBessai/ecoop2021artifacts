package vita.ep.i2;

public interface Exp<V> extends vita.ep.i1.Exp<V>, Factory<V> {

    public abstract vita.ep.i2.Exp<V> multby(vita.ep.Exp<V> other);
}
