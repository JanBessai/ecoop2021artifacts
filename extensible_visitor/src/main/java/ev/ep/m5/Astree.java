package ev.ep.m5;

import util.Leaf;
import util.Node;
import util.Tree;

import ev.ep.m3.VisitorDivdMultNeg;

public class Astree implements VisitorDivdMultNeg<Tree> {

    public Astree() { }

    public Tree visit(ev.ep.m0.Lit exp) { return new Node(exp.<Integer>accept(this.makeId()), new Leaf<>(exp.getValue())); }
    public Tree visit(ev.ep.m0.Add exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this), exp.getRight().accept(this));
    }
    public Tree visit(ev.ep.m1.Sub exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this), exp.getRight().accept(this));
    }
    public Tree visit(ev.ep.m3.Mult exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this), exp.getRight().accept(this));
    }
    public Tree visit(ev.ep.m3.Neg exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getInner().accept(this));
    }
    public Tree visit(ev.ep.m3.Divd exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this), exp.getRight().accept(this));
    }

    public Id makeId() {
        return new Id();
    }
}
