package interpreter.ep.i2;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.i1.MultByLit;

public class EvalPrettypMultByExpFactory {

    public static MultByExp lit(Double value) {
        return new MultByLit(value);
    }

    public static MultByExp add(MultByExp left, MultByExp right) {
        return new EvalPrettypMultByAdd(left, right);
    }

    public static MultByExp sub(MultByExp left, MultByExp right) {
        return new EvalPrettypMultBySub(left, right);
    }

    public static MultByExp power(MultByExp left, MultByExp right) {
        return new EvalPrettypMultByPower(left, right);
    }

}
