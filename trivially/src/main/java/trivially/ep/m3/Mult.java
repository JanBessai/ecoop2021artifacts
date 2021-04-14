package trivially.ep.m3;

import trivially.ep.m2.Exp;

public interface Mult extends trivially.ep.m2.Exp {

    Exp getLeft();

    Exp getRight();

    default String prettyp() {
        return "(" + this.getLeft().prettyp() + "*" + this.getRight().prettyp() + ")";
    }

    default Double eval() {
        return this.getLeft().eval() * this.getRight().eval();
    }
}
