package trivially.ep.i2;

public interface Sub<V> extends trivially.ep.i1.Sub<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Exp<V> multby(trivially.ep.Exp<V> other) {
        return this.sub(this.getLeft().multby(convert(other)), this.getRight().multby(convert(other)));
    }
}
