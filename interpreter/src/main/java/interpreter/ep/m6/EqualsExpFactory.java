package interpreter.ep.m6;

public class EqualsExpFactory {

    public static EqualsExp Neg(EqualsExp inner) {
        return new EqualsNeg(inner);
    }

    public static EqualsExp Mult(EqualsExp left, EqualsExp right) {
        return new EqualsMult(left, right);
    }

    public static EqualsExp Divd(EqualsExp left, EqualsExp right) {
        return new EqualsDivd(left, right);
    }

    public static EqualsExp Sub(EqualsExp left, EqualsExp right) {
        return new EqualsSub(left, right);
    }

    public static EqualsExp Lit(Double value) {
        return new EqualsLit(value);
    }

    public static EqualsExp Add(EqualsExp left, EqualsExp right) {
        return new EqualsAdd(left, right);
    }
}
