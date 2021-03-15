package vita.ep.m0;

public interface Exp<V> extends vita.ep.Exp<V>, Factory<V> {

    public abstract Double eval();
}
