package ev.ep.i2;

import ev.ep.m1.VisitorSub;

public interface VisitorPower<R> extends VisitorSub<R> {

    R visit(Power exp);
}
