package trivially.ep.m5;

import util.Node;
import util.Tree;

public interface Neg extends Exp, trivially.ep.m4.Neg {

    Exp getInner();

    default Tree astree() {
        return new Node(this.id(), this.getInner().astree());
    }

    default Integer id() {
        return 78192;
    }

    default Exp simplify() {
        if (this.getInner().eval().equals(0.0)) {
            return new trivially.ep.m5.finalized.Lit(0.0);
        } else {
            return new trivially.ep.m5.finalized.Neg(this.getInner().simplify());
        }
    }

    default void truncate (int level) {
        if (level > 1) {
            getInner().truncate(level-1);
        } else {
            setInner(new trivially.ep.m5.finalized.Lit(getInner().eval()));
        }
    }
}
