package coco.ep.m5;

import util.Leaf;
import util.Node;
import util.Tree;

public interface Lit<FT> extends coco.ep.m4.Lit<FT>, Exp<FT> {

    default Tree astree() {
        return new Node(convert(this).id(), new Leaf<>(getValue()));
    }

    default Integer id() {
        return 76407;
    }
}
