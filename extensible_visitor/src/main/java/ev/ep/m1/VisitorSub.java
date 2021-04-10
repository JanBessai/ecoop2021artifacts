package ev.ep.m1;

import ev.ep.Visitor;

public interface VisitorSub<R> extends Visitor<R> {

    R visit(Sub exp);
}
