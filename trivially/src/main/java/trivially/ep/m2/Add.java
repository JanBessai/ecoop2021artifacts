package trivially.ep.m2;

public interface Add extends Exp, trivially.ep.m0.Add {

    Exp getLeft();

    Exp getRight();

    default String prettyp() {
        return "(" + this.getLeft().prettyp() + "+" + this.getRight().prettyp() + ")";
    }
}
