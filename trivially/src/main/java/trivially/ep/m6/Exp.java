package trivially.ep.m6;

public interface Exp<V> extends trivially.ep.m5.Exp<V> {

    Boolean equals(trivially.ep.Exp<V> other);
    Boolean eql(trivially.ep.Exp<V> other);

    default Boolean isLit(Double d) { return false; }
    default Boolean isAdd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right) { return false; }
    default Boolean isSub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right) { return false; }
    default Boolean isMult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right) { return false; }
    default Boolean isNeg(trivially.ep.Exp<V>inner) { return false; }
    default Boolean isDivd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right) { return false; }

    trivially.ep.m6.Exp<V> simplify();

    trivially.ep.m6.Exp<V> sub(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m6.Exp<V> neg(trivially.ep.Exp<V> inner);

    trivially.ep.m6.Exp<V> mult(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m6.Exp<V> divd(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m6.Exp<V> lit(Double value);

    trivially.ep.m6.Exp<V> add(trivially.ep.Exp<V> left, trivially.ep.Exp<V> right);

    trivially.ep.m6.Exp<V> convert(trivially.ep.Exp<V> other);
}
