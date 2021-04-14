package trivially.ep.m2;

public interface Sub extends Exp, trivially.ep.m1.Sub {

    Exp getLeft();

    Exp getRight();

    default String prettyp() {
        return "(" + this.getLeft().prettyp() + "-" + this.getRight().prettyp() + ")";
    }
}
