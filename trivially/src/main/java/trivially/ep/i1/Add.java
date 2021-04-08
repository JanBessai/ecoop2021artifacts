package trivially.ep.i1;

public interface Add<V> extends trivially.ep.m2.Add<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.add(this.convert(this.getLeft()).multby(this.convert(other)), this.convert(this.getRight()).multby(this.convert(other)));
    }
}
