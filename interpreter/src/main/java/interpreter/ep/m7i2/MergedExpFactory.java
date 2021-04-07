package interpreter.ep.m7i2;

public class MergedExpFactory {

    public static MergedExp Power(MergedExp left, MergedExp right) {
        return new MergedPower(left, right);
    }

    public static MergedExp Neg(MergedExp inner) {
        return new MergedNeg(inner);
    }

    public static MergedExp Mult(MergedExp left, MergedExp right) {
        return new MergedMult(left, right);
    }

    public static MergedExp Divd(MergedExp left, MergedExp right) {
        return new MergedDivd(left, right);
    }

    public static MergedExp Sub(MergedExp left, MergedExp right) {
        return new MergedSub(left, right);
    }

    public static MergedExp Lit(Double value) {
        return new MergedLit(value);
    }

    public static MergedExp Add(MergedExp left, MergedExp right) {
        return new MergedAdd(left, right);
    }
}
