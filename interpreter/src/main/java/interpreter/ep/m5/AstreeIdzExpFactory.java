package interpreter.ep.m5;

public class AstreeIdzExpFactory {

    public static AstreeIdzExp Neg(AstreeIdzExp inner) {
        return new AstreeIdzNeg(inner);
    }

    public static AstreeIdzExp Mult(AstreeIdzExp left, AstreeIdzExp right) {
        return new AstreeIdzMult(left, right);
    }

    public static AstreeIdzExp Divd(AstreeIdzExp left, AstreeIdzExp right) {
        return new AstreeIdzDivd(left, right);
    }

    public static AstreeIdzExp Sub(AstreeIdzExp left, AstreeIdzExp right) {
        return new AstreeIdzSub(left, right);
    }

    public static AstreeIdzExp Lit(Double value) {
        return new AstreeIdzLit(value);
    }

    public static AstreeIdzExp Add(AstreeIdzExp left, AstreeIdzExp right) {
        return new AstreeIdzAdd(left, right);
    }
}
