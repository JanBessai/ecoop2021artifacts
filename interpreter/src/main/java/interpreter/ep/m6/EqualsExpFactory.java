package interpreter.ep.m6;

public class EqualsExpFactory {

    public static EqualsExp neg(EqualsExp inner) {
        return new EqualsNeg(inner);
    }

    public static EqualsExp mult(EqualsExp left, EqualsExp right) {
        return new EqualsMult(left, right);
    }

    public static EqualsExp divd(EqualsExp left, EqualsExp right) {
        return new EqualsDivd(left, right);
    }

    public static EqualsExp sub(EqualsExp left, EqualsExp right) {
        return new EqualsSub(left, right);
    }

    public static EqualsExp lit(Double value) {
        return new EqualsLit(value);
    }

    public static EqualsExp add(EqualsExp left, EqualsExp right) {
        return new EqualsAdd(left, right);
    }
}
