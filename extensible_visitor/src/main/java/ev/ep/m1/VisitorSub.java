package ev.ep.m1;

import ev.ep.m0.VisitorAddLit;

public interface VisitorSub<R> extends VisitorAddLit<R> {
    R visit(Sub exp);
}
