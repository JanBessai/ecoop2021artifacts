package trivially.ep.m3;

import trivially.ep.m2.Exp;

public interface Neg extends trivially.ep.m2.Exp {

    Exp getInner();

    default String prettyp() {
        return "(-" + this.getInner().prettyp() + ")";
    }

    default Double eval() {
        return -1.0 * this.getInner().eval();
    }
}
