package trivially.ep.m3;

public interface Sub<V> extends trivially.ep.m2.Sub<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();
}
