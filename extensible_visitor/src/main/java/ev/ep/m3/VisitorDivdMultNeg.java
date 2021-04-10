package ev.ep.m3;

import ev.ep.m1.VisitorSub;

public interface VisitorDivdMultNeg<R> extends VisitorSub<R> {

    R visit(Neg exp);

    R visit(Mult exp);

    R visit(Divd exp);
}
