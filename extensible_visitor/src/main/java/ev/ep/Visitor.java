package ev.ep;

import ev.ep.m0.Add;
import ev.ep.m0.Lit;

public interface Visitor<R> {

    R visit(Lit exp);

    R visit(Add exp);
}
