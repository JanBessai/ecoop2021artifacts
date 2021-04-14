package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.i2.Power;
import ev.ep.m6.*;

public class EqlMerged extends Eql implements VisitorMerged<Boolean> {

    public EqlMerged(Exp _other) {
       super(_other);
    }

    public EqlMerged makeEql(Exp _other) { return new EqlMerged(_other); }

    @Override
    public Boolean visit(Power exp) {
        return other.accept(makeIsPower(exp.getLeft(), exp.getRight()));
    }

    public IsLitMerged makeIsLit(Double d) { return new IsLitMerged(d); }
    public IsAddMerged makeIsAdd(Exp left, Exp right) { return new IsAddMerged(left, right); }
    public IsSubMerged makeIsSub(Exp left, Exp right) { return new IsSubMerged(left, right); }
    public IsMultMerged makeIsMult(Exp left, Exp right) { return new IsMultMerged(left, right); }
    public IsNegMerged makeIsNeg(Exp inner) { return new IsNegMerged(inner); }
    public IsDivdMerged makeIsDivd(Exp left, Exp right) { return new IsDivdMerged(left, right); }

    public IsPowerMerged makeIsPower(Exp left, Exp right) { return new IsPowerMerged(left, right); }
}

