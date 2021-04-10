package ev.ep.m4;

import ev.ep.m3.VisitorDivdMultNeg;

public interface VisitorDivdMultNegTruncate<R> extends VisitorDivdMultNeg<R> {

    R visit(Lit exp);

    R visit(Add exp);

    R visit(Sub exp);

    R visit(Neg exp);

    R visit(Mult exp);

    R visit(Divd exp);
}
