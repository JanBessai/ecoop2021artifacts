package ev.ep.m0;

import ev.ep.Visitor;

public interface VisitorAddLit<R> extends Visitor<R> {

    R visit(Lit exp);

    R visit(Add exp);
}
