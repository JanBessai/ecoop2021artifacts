package trivially.ep.m1;

import trivially.ep.m0.Exp;

public interface Sub extends trivially.ep.m0.Exp {

    Exp getLeft();

    Exp getRight();

    default Double eval() {
        return this.getLeft().eval() - this.getRight().eval();
    }
}
