package trivially.ep.m5;

import trivially.ep.m5.finalized.Lit;
import util.Node;
import util.Tree;

public interface Sub extends Exp, trivially.ep.m4.Sub {

    Exp getLeft();

    Exp getRight();

    default Tree astree() {
        return new Node(this.id(), this.getLeft().astree(), this.getRight().astree());
    }

    default Integer id() {
        return 83488;
    }

    default Exp simplify() {
        if (this.getLeft().eval().equals(this.getRight().eval())) {
            return new Lit(0.0);
        } else {
            return new trivially.ep.m5.finalized.Sub(this.getLeft().simplify(), this.getRight().simplify());
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
