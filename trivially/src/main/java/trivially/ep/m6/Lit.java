package trivially.ep.m6;

public interface Lit<V> extends trivially.ep.m5.Lit<V>, Exp<V> {

    Double getValue();

    default Boolean equals(trivially.ep.Exp<V> other) {
        return this.astree().equals(convert(other).astree());
    }

    default Boolean isLit(Double d) {
        return d.equals(getValue());
    }

    default Boolean eql(trivially.ep.Exp<V> that) {
        return convert(that).isLit(getValue());
    }

    default Exp<V> simplify() {
        return convert(trivially.ep.m5.Lit.super.simplify());
    }
}
