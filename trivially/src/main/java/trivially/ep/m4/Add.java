package trivially.ep.m4;

import trivially.ep.m4.finalized.Lit;
import java.util.List;

public interface Add extends Exp, trivially.ep.m2.Add {

    Exp getLeft();

    Exp getRight();

    void setLeft(Exp exp);

    void setRight(Exp exp);

    default Exp simplify() {
        if (Double.valueOf(this.getLeft().eval() + this.getRight().eval()).equals(0.0)) {
            return new Lit(0.0);
        } else if (Double.valueOf(this.getLeft().eval()).equals(0.0)) {
            return this.getRight().simplify();
        } else if (Double.valueOf(this.getRight().eval()).equals(0.0)) {
            return this.getLeft().simplify();
        } else {
            return new trivially.ep.m4.finalized.Add(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default List<Double> collect() {
        return java.util.stream.Stream.concat(this.getLeft().collect().stream(), this.getRight().collect().stream()).collect(java.util.stream.Collectors.toList());
    }

    default void truncate (int level) {
        if (level > 1) {
            getLeft().truncate(level-1);
            getRight().truncate(level-1);
        } else {
            setLeft(new Lit(getLeft().eval()));
            setRight(new Lit(getRight().eval()));
        }
    }
}
