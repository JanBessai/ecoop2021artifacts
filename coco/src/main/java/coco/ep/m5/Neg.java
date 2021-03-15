package coco.ep.m5;

import coco.ep.m5.Exp;
import util.Node;
import util.Tree;

public interface Neg<FT> extends coco.ep.m4.Neg<FT>, Exp<FT> {

    public default Tree astree() {
        return new Node(this.convert(this).id(), this.convert(this.getInner()).astree());
    }

    public default Integer id() {
        return 78192;
    }
}
