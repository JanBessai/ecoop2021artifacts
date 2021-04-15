package trivially.ep.i1;

public interface Add extends Exp, trivially.ep.m2.Add {

    Exp getLeft();
    Exp getRight();

    default Exp multby(Exp other) {
        return new trivially.ep.i1.finalized.Add(this.getLeft().multby(other), this.getRight().multby(other));
    }
}
