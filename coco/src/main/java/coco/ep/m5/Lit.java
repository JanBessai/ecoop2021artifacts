package coco.ep.m5;

import coco.ep.m5.Exp;
import util.Leaf;
import util.Node;
import util.Tree;

public interface Lit<FT> extends coco.ep.m4.Lit<FT>, Exp<FT> {

    public default Tree astree() {
        return new Node(this.convert(this).id(), new Leaf<Double>(this.getValue()));
    }

    public default Integer id() {
        return 76407;
    }
}
