package coco.ep.m5;

import coco.ep.m5.Exp;
import util.Node;
import util.Tree;

public interface Add<FT> extends coco.ep.m4.Add<FT>, Exp<FT> {

    public default Tree astree() {
        return new Node(this.convert(this).id(), this.convert(this.getLeft()).astree(), this.convert(this.getRight()).astree());
    }

    public default Integer id() {
        return 65665;
    }
}
