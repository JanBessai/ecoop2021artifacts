package trivially.ep.m5;

import trivially.ep.m5.finalized.Lit;
import util.Node;
import util.Tree;

public interface Divd extends Exp, trivially.ep.m4.Divd {

    Exp getLeft();
    Exp getRight();

    default Tree astree() {
        return new Node(this.id(), this.getLeft().astree(), this.getRight().astree());
    }

    default Integer id() {
        return 2130451;
    }

    default Exp simplify() {
        if (this.getLeft().eval().equals(0.0)) {
            return new Lit(0.0);
        } else if (this.getRight().eval().equals(1.0)) {
            return this.getLeft().simplify();
        } else if (this.getLeft().eval().equals(this.getRight().eval())) {
            return new Lit(1.0);
        } else if (this.getLeft().eval().equals(-1.0 * this.getRight().eval())) {
            return new Lit(-1.0);
        } else {
            return new trivially.ep.m5.finalized.Divd(this.getLeft().simplify(), this.getRight().simplify());
        }
    }

    default void truncate (int level) {
        if (level > 1) {
            getLeft().truncate(level-1);
            getRight().truncate(level-1);
        } else {
            setLeft(new trivially.ep.m5.finalized.Lit(getLeft().eval()));
            setRight(new trivially.ep.m5.finalized.Lit(getRight().eval()));
        }
    }
}
