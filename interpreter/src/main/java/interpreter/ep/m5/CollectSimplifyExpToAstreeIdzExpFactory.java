package interpreter.ep.m5;

import interpreter.ep.m4.CollectSimplifyExp;

public class CollectSimplifyExpToAstreeIdzExpFactory {

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

    public static AstreeIdzExp convert(CollectSimplifyExp exp) {
        if (exp instanceof interpreter.ep.m4.CollectSimplifyNeg) {
            interpreter.ep.m4.CollectSimplifyNeg o = (interpreter.ep.m4.CollectSimplifyNeg) exp;
            return Neg(convert(o.getInner()));
        }

        if (exp instanceof interpreter.ep.m4.CollectSimplifyMult) {
            interpreter.ep.m4.CollectSimplifyMult o = (interpreter.ep.m4.CollectSimplifyMult) exp;
            return Mult(convert(o.getLeft()), convert(o.getRight()));
        }

        if (exp instanceof interpreter.ep.m4.CollectSimplifyDivd) {
            interpreter.ep.m4.CollectSimplifyDivd o = (interpreter.ep.m4.CollectSimplifyDivd) exp;
            return Divd(convert(o.getLeft()), convert(o.getRight()));
        }

        if (exp instanceof interpreter.ep.m4.CollectSimplifySub) {
            interpreter.ep.m4.CollectSimplifySub o = (interpreter.ep.m4.CollectSimplifySub) exp;
            return Sub(convert(o.getLeft()), convert(o.getRight()));
        }

        if (exp instanceof interpreter.ep.m4.CollectSimplifyLit) {
            return Lit(((interpreter.ep.m4.CollectSimplifyLit) exp).getValue());
        }

        if (exp instanceof interpreter.ep.m4.CollectSimplifyAdd) {
            interpreter.ep.m4.CollectSimplifyAdd o = (interpreter.ep.m4.CollectSimplifyAdd) exp;
            return Add(convert(o.getLeft()), convert(o.getRight()));
        }

        throw new IllegalArgumentException("Unknown subtype:" + exp);
    }
}
