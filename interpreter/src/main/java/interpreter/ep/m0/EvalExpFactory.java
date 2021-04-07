package interpreter.ep.m0;

public class EvalExpFactory {

    public static EvalExp Lit(Double value) {
        return new EvalLit(value);
    }

    public static EvalExp Add(EvalExp left, EvalExp right) {
        return new EvalAdd(left, right);
    }
}
