package trivially.ep.m3;

public interface Add<V> extends trivially.ep.m2.Add<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();
}
