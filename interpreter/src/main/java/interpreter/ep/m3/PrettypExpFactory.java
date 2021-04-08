package interpreter.ep.m3;

import interpreter.ep.m2.PrettypAdd;
import interpreter.ep.m2.PrettypExp;
import interpreter.ep.m2.PrettypLit;
import interpreter.ep.m2.PrettypSub;

public class PrettypExpFactory {
    public static PrettypExp lit(Double value) {
        return new PrettypLit(value);
    }

    public static PrettypExp add(PrettypExp left, PrettypExp right) {
        return new PrettypAdd(left, right);
    }

    public static PrettypExp sub(PrettypExp left, PrettypExp right) {
        return new PrettypSub(left, right);
    }

    public static PrettypExp mult(PrettypExp left, PrettypExp right) { return new PrettypMult(left, right); }

    public static PrettypExp neg(PrettypExp inner) { return new PrettypNeg(inner); }

    public static PrettypExp divd(PrettypExp left, PrettypExp right) {
        return new PrettypDivd(left, right);
    }
}
