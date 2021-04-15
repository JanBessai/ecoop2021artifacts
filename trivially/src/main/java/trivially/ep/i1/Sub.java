package trivially.ep.i1;

public interface Sub extends Exp, trivially.ep.m2.Sub {

    Exp getLeft();
    Exp getRight();

    default Exp multby(Exp other) {
        return new trivially.ep.i1.finalized.Sub(this.getLeft().multby(other), this.getRight().multby(other));
    }
}
