package interpreter.ep.m7;

public class PowByExpFactory {

    public static PowByExp sub(PowByExp left, PowByExp right) {
        return new PowBySub(left, right);
    }

    public static PowByExp lit(Double value) {
        return new PowByLit(value);
    }

    public static PowByExp add(PowByExp left, PowByExp right) {
        return new PowByAdd(left, right);
    }
    
    public static PowByExp mult(PowByExp left, PowByExp right) {
        return new PowByMult(left, right);
    }
    
    public static PowByExp divd(PowByExp left, PowByExp right) {
        return new PowByDivd(left, right);
    }
    
    public static PowByExp neg(PowByExp inner) {
        return new PowByNeg(inner);
    }
}
