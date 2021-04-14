package trivially.ep.m6;

public interface Exp extends trivially.ep.m5.Exp {

    Boolean equals(trivially.ep.m6.Exp other);
    Boolean eql(trivially.ep.m6.Exp other);

    trivially.ep.m6.Exp simplify();

    default Boolean isLit(Double d) { return false; }
    default Boolean isAdd(Exp left, Exp right) { return false; }
    default Boolean isSub(Exp left, Exp right) { return false; }
    default Boolean isMult(Exp left, Exp right) { return false; }
    default Boolean isNeg(Exp inner) { return false; }
    default Boolean isDivd(Exp left, Exp right) { return false; }
}
