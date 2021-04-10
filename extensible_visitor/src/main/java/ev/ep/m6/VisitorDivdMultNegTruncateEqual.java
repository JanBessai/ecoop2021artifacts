package ev.ep.m6;

import ev.ep.m4.VisitorDivdMultNegTruncate;

public interface VisitorDivdMultNegTruncateEqual<R> extends VisitorDivdMultNegTruncate<R> {

    R visit(Lit exp);

    R visit(Add exp);

    R visit(Sub exp);

    R visit(Neg exp);

    R visit(Mult exp);

    R visit(Divd exp);
}
