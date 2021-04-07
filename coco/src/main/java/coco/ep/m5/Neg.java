package coco.ep.m5;

import util.Node;
import util.Tree;

public interface Neg<FT> extends coco.ep.m4.Neg<FT>, Exp<FT> {

    default Tree astree() {
        return new Node(convert(this).id(), convert(getInner()).astree());
    }

    default Integer id() {
        return 78192;
    }
}
