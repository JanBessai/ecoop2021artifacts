package interpreter.ep.m2;

public class PrettypExpFactory {

    public static PrettypExp sub(PrettypExp left, PrettypExp right) {
        return new PrettypSub(left, right);
    }

    public static PrettypExp lit(Double value) {
        return new PrettypLit(value);
    }

    public static PrettypExp add(PrettypExp left, PrettypExp right) {
        return new PrettypAdd(left, right);
    }
}
