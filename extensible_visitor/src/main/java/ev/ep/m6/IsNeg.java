package ev.ep.m6;

import ev.ep.Exp;

public class IsNeg implements IsDataType {
    Exp inner;

    public IsNeg(Exp _inner) {
        this.inner = _inner;
    }

    public Boolean visit(ev.ep.m3.Neg exp) {
        return exp.getInner().accept(makeEql(inner));
    }
}
