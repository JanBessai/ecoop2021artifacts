package trivially.ep.m5;

import util.Leaf;
import util.Node;
import util.Tree;

public interface Lit extends Exp, trivially.ep.m4.Lit {

    Double getValue();

    default Tree astree() {
        return new Node(this.id(), new Leaf<>(this.getValue()));
    }

    default Integer id() {
        return 76407;
    }

    default Exp simplify() {
        return this;
    }
}
