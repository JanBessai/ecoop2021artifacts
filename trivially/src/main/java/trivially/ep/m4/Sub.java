package trivially.ep.m4;

import trivially.ep.m4.finalized.Lit;
import java.util.List;

public interface Sub extends Exp, trivially.ep.m2.Sub {

    Exp getLeft();

    Exp getRight();

    void setLeft(Exp exp);

    void setRight(Exp exp);

    default Exp simplify() {
        if (this.getLeft().eval().equals(this.getRight().eval())) {
            return new Lit(0.0);
        } else {
            return new trivially.ep.m4.finalized.Sub(this.getLeft().simplify(), this.getRight().simplify());
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
