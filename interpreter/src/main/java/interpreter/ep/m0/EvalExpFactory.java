package interpreter.ep.m0;

public class EvalExpFactory {

    public static EvalExp lit(Double value) {
        return new EvalLit(value);
    }

    public static EvalExp add(EvalExp left, EvalExp right) {
        return new EvalAdd(left, right);
    }
}
