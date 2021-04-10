package ev.ep.m7i2;

import ev.ep.i2.VisitorPower;
import ev.ep.m4.VisitorDivdMultNegTruncate;

public interface VisitorMerged<R> extends VisitorDivdMultNegTruncate<R>, VisitorPower<R> {

    R visit(Lit exp);
    R visit(Add exp);
    R visit(Sub exp);
    R visit(Neg exp);
    R visit(Mult exp);
    R visit(Divd exp);

    R visit(Power exp);
}
