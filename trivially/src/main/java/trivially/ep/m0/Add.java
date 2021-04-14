package trivially.ep.m0;

public interface Add extends Exp {

    Exp getLeft();

    Exp getRight();

    default Double eval() {
        return this.getLeft().eval() + this.getRight().eval();
    }
}
