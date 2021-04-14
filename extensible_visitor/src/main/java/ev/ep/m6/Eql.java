package ev.ep.m6;

import ev.ep.Exp;
import ev.ep.m3.VisitorDivdMultNeg;

/**
 * Eql demands that the Exp class provides default isDataType() helper methods
 * which are overridden by the respective subclasses. As such, any attempt
 * to invoke Eql on an older data type instance will fail.
 */
public class Eql implements VisitorDivdMultNeg<Boolean> {

    protected Exp other;

    public Eql(Exp _other) {
        this.other = _other;
    }

    public Boolean visit(ev.ep.m0.Lit exp) {
        return other.accept(makeIsLit(exp.getValue()));
    }

    public Boolean visit(ev.ep.m0.Add exp) {
        return other.accept(makeIsAdd(exp.getLeft(), exp.getRight()));
    }
    public Boolean visit(ev.ep.m1.Sub exp) {
        return other.accept(makeIsSub(exp.getLeft(), exp.getRight()));
    }
    public Boolean visit(ev.ep.m3.Mult exp) {
        return other.accept(makeIsMult(exp.getLeft(), exp.getRight()));
    }
    public Boolean visit(ev.ep.m3.Neg exp) {
        return other.accept(makeIsNeg(exp.getInner()));
    }
    public Boolean visit(ev.ep.m3.Divd exp) {
        return other.accept(makeIsDivd(exp.getLeft(), exp.getRight()));
    }

    public IsLit makeIsLit(Double d) { return new IsLit(d); }
    public IsAdd makeIsAdd(Exp left, Exp right) { return new IsAdd(left, right); }
    public IsSub makeIsSub(Exp left, Exp right) { return new IsSub(left, right); }
    public IsMult makeIsMult(Exp left, Exp right) { return new IsMult(left, right); }
    public IsNeg makeIsNeg(Exp inner) { return new IsNeg(inner); }
    public IsDivd makeIsDivd(Exp left, Exp right) { return new IsDivd(left, right); }
}
