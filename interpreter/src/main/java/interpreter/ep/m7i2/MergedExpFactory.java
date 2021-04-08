package interpreter.ep.m7i2;

public class MergedExpFactory {

    public static MergedExp power(MergedExp left, MergedExp right) {
        return new MergedPower(left, right);
    }

    public static MergedExp neg(MergedExp inner) {
        return new MergedNeg(inner);
    }

    public static MergedExp mult(MergedExp left, MergedExp right) {
        return new MergedMult(left, right);
    }

    public static MergedExp divd(MergedExp left, MergedExp right) {
        return new MergedDivd(left, right);
    }

    public static MergedExp sub(MergedExp left, MergedExp right) {
        return new MergedSub(left, right);
    }

    public static MergedExp lit(Double value) {
        return new MergedLit(value);
    }

    public static MergedExp add(MergedExp left, MergedExp right) {
        return new MergedAdd(left, right);
    }
}
