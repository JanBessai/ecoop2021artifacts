package coco.ep.m5;

import util.Node;
import util.Tree;

public interface Divd<FT> extends coco.ep.m4.Divd<FT>, Exp<FT> {

    default Tree astree() {
        return new Node(convert(this).id(), convert(getLeft()).astree(), convert(getRight()).astree());
    }

    default Integer id() {
        return 2130451;
    }
}
