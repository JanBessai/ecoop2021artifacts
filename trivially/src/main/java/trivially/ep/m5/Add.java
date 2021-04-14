package trivially.ep.m5;

import trivially.ep.m5.finalized.Lit;
import util.Node;
import util.Tree;

public interface Add extends Exp, trivially.ep.m4.Add {

    Exp getLeft();

    Exp getRight();

    default Tree astree() {
        return new Node(this.id(), this.getLeft().astree(), this.getRight().astree());
    }

    default Integer id() {
        return 65665;
    }

    default Exp simplify() {
        if (Double.valueOf(this.getLeft().eval() + this.getRight().eval()).equals(0.0)) {
            return new Lit(0.0);
        } else if (Double.valueOf(this.getLeft().eval()).equals(0.0)) {
            return this.getRight().simplify();
        } else if (Double.valueOf(this.getRight().eval()).equals(0.0)) {
            return this.getLeft().simplify();
        } else {
            return new trivially.ep.m5.finalized.Add(this.getLeft().simplify(), this.getRight().simplify());
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
