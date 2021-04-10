package ev.ep.m5;

import ev.ep.m4.*;
import util.Leaf;
import util.Node;
import util.Tree;

public class Astree implements VisitorDivdMultNegTruncate<Tree> {

    public Astree() { }

    // unsafe runtime exceptions
    public Tree visit(ev.ep.m0.Lit exp) { return visit((ev.ep.m4.Lit)exp); }
    public Tree visit(ev.ep.m0.Add exp) {
        return visit((ev.ep.m4.Add)exp);
    }
    public Tree visit(ev.ep.m1.Sub exp) {
        return visit((ev.ep.m4.Sub)exp);
    }
    public Tree visit(ev.ep.m3.Neg exp) {
        return visit((ev.ep.m4.Neg)exp);
    }
    public Tree visit(ev.ep.m3.Divd exp) {
        return visit((ev.ep.m4.Divd)exp);
    }
    public Tree visit(ev.ep.m3.Mult exp) {
        return visit((ev.ep.m4.Mult)exp);
    }

    public Tree visit(Neg exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getInner().accept(this.makeAstree()));
    }

    public Tree visit(Mult exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this.makeAstree()), exp.getRight().accept(this.makeAstree()));
    }

    public Tree visit(Divd exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this.makeAstree()), exp.getRight().accept(this.makeAstree()));
    }

    public Tree visit(Sub exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this.makeAstree()), exp.getRight().accept(this.makeAstree()));
    }

    public Tree visit(Lit exp) {
        return new Node(exp.<Integer>accept(this.makeId()), new Leaf<>(exp.getValue()));
    }

    public Tree visit(Add exp) {
        return new Node(exp.<Integer>accept(this.makeId()), exp.getLeft().accept(this.makeAstree()), exp.getRight().accept(this.makeAstree()));
    }

    public Id makeId() {
        return new Id();
    }

    public Astree makeAstree() {
        return new Astree();
    }
}
