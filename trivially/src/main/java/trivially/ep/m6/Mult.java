package trivially.ep.m6;

public interface Mult<V> extends trivially.ep.m5.Mult<V>, Exp<V> {

    Exp<V> getLeft();
    Exp<V> getRight();

    default Boolean equals(trivially.ep.Exp<V> other) {
        return this.astree().equals(convert(other).astree());
    }
    @Override
    default Boolean isMult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right) {
        return convert(left).eql(getLeft()) && convert(right).eql(getRight());
    }

    default Boolean eql(trivially.ep.Exp<V> that) {
        return convert(that).isMult(getLeft(), getRight());
    }
    default Exp<V> simplify() {
        return convert(trivially.ep.m5.Mult.super.simplify());
    }
}
