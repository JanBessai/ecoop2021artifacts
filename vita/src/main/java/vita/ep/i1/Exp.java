package vita.ep.i1;

public interface Exp<V> extends vita.ep.m2.Exp<V>, Factory<V> {

    public abstract vita.ep.i1.Exp<V> multby(vita.ep.Exp<V> other);
}
