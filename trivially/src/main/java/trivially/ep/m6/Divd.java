package trivially.ep.m6;

public interface Divd<V> extends trivially.ep.m5.Divd<V>, Exp<V> {

    Exp<V> getLeft();

    Exp<V> getRight();

    default Boolean equals(trivially.ep.Exp<V> other) {
        return this.astree().equals(this.convert(other).astree());
    }

    @Override
    default Boolean isDivd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right) {
        return this.convert(left).eql(getLeft()) && this.convert(right).eql(getRight());
    }

    default Boolean eql(trivially.ep.Exp<V> that) {
        return this.convert(that).isDivd(getLeft(), getRight());
    }

    default Exp<V> simplify() {
        return this.convert(trivially.ep.m5.Divd.super.simplify());
    }
}
