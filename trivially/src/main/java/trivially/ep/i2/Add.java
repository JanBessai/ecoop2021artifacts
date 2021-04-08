package trivially.ep.i2;

public interface Add<V> extends trivially.ep.i1.Add<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.add(convert(this.getLeft()).multby(convert(other)), convert(this.getRight()).multby(convert(other)));
    }
}
