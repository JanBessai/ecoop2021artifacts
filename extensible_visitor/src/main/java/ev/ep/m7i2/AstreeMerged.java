package ev.ep.m7i2;

import ev.ep.i2.VisitorPower;
import ev.ep.i2.Power;
import ev.ep.m0.Add;
import ev.ep.m0.Lit;
import ev.ep.m1.Sub;
import ev.ep.m3.Divd;
import ev.ep.m3.Mult;
import ev.ep.m3.Neg;
import ev.ep.m5.Astree;
import util.Leaf;
import util.Node;
import util.Tree;

public class AstreeMerged extends Astree implements VisitorPower<Tree> {

    public AstreeMerged() {
    }

    public Tree visit(Power exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this), exp.getRight().accept(this));
    }

    public IdMerged makeId() {
        return new IdMerged();
    }

}
