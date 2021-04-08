package trivially.ep.m6;

public interface Sub<V> extends trivially.ep.m5.Sub<V>, Exp<V> {

    Exp<V> getLeft();

    Exp<V> getRight();

    default Boolean equals(trivially.ep.Exp<V> other) {
        return this.astree().equals(convert(other).astree());
    }

    @Override
    default Boolean isSub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right) {
        return convert(left).eql(getLeft()) && convert(right).eql(getRight());
    }

    default Boolean eql(trivially.ep.Exp<V> that) {
        return convert(that).isSub(getLeft(), getRight());
    }

    default Exp<V> simplify() {
        return convert(trivially.ep.m5.Sub.super.simplify());
    }
}
