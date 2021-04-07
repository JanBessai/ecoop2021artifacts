package coco.ep.m5;

import util.Node;
import util.Tree;

public interface Mult<FT> extends coco.ep.m4.Mult<FT>, Exp<FT> {

    default Tree astree() {
        return new Node(convert(this).id(), convert(getLeft()).astree(), convert(getRight()).astree());
    }

    default Integer id() {
        return 2409808;
    }
}
