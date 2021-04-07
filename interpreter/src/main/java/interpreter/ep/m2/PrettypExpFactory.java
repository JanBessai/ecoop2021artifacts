package interpreter.ep.m2;

public class PrettypExpFactory {

    public static PrettypExp Sub(PrettypExp left, PrettypExp right) {
        return new PrettypSub(left, right);
    }

    public static PrettypExp Lit(Double value) {
        return new PrettypLit(value);
    }

    public static PrettypExp Add(PrettypExp left, PrettypExp right) {
        return new PrettypAdd(left, right);
    }
}
