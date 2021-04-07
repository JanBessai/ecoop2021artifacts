package interpreter.ep.m1;

import interpreter.ep.m0.EvalExp;

public class EvalSubFactory {
    public static EvalExp Sub(EvalExp left, EvalExp right) {
        return new EvalSub(left, right);
    }
}
