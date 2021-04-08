package interpreter.ep.m1;

import interpreter.ep.m0.EvalAdd;
import interpreter.ep.m0.EvalExp;
import interpreter.ep.m0.EvalLit;

public class EvalSubFactory {
    public static EvalExp lit(Double value) {
        return new EvalLit(value);
    }
    public static EvalExp add(EvalExp left, EvalExp right) {
        return new EvalAdd(left, right);
    }
    public static EvalExp sub(EvalExp left, EvalExp right) { return new EvalSub(left, right); }
}
