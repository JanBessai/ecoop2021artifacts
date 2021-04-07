package interpreter.ep.m7;

public class PowByExpFactory {

    public static PowByExp Sub(PowByExp left, PowByExp right) {
        return new PowBySub(left, right);
    }

    public static PowByExp Lit(Double value) {
        return new PowByLit(value);
    }

    public static PowByExp Add(PowByExp left, PowByExp right) {
        return new PowByAdd(left, right);
    }
    
    public static PowByExp Mult(PowByExp left, PowByExp right) {
        return new PowByMult(left, right);
    }
    
    public static PowByExp Divd(PowByExp left, PowByExp right) {
        return new PowByDivd(left, right);
    }
    
    public static PowByExp Neg(PowByExp inner) {
        return new PowByNeg(inner);
    }
}
