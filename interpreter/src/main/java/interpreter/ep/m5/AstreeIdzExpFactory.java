package interpreter.ep.m5;

public class AstreeIdzExpFactory {

    public static AstreeIdzExp neg(AstreeIdzExp inner) {
        return new AstreeIdzNeg(inner);
    }

    public static AstreeIdzExp mult(AstreeIdzExp left, AstreeIdzExp right) {
        return new AstreeIdzMult(left, right);
    }

    public static AstreeIdzExp divd(AstreeIdzExp left, AstreeIdzExp right) {
        return new AstreeIdzDivd(left, right);
    }

    public static AstreeIdzExp sub(AstreeIdzExp left, AstreeIdzExp right) {
        return new AstreeIdzSub(left, right);
    }

    public static AstreeIdzExp lit(Double value) {
        return new AstreeIdzLit(value);
    }

    public static AstreeIdzExp add(AstreeIdzExp left, AstreeIdzExp right) {
        return new AstreeIdzAdd(left, right);
    }
}
