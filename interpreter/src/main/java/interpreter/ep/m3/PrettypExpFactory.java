package interpreter.ep.m3;

import interpreter.ep.m2.PrettypExp;

public class PrettypExpFactory {

    public static PrettypExp Mult(PrettypExp left, PrettypExp right) {
        return new PrettypMult(left, right);
    }

    public static PrettypExp Neg(PrettypExp inner) { return new PrettypNeg(inner); }

    public static PrettypExp Divd(PrettypExp left, PrettypExp right) {
        return new PrettypDivd(left, right);
    }
}
