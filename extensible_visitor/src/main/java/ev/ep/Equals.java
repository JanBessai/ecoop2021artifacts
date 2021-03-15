package ev.ep;

import util.Tree;

public class Equals implements VisitorDivdMultNeg<Boolean> {

    protected Exp other;

    public Equals(Exp _other) {
        this.other = _other;
    }

    public Boolean visit(Neg exp) {
        return exp.<Tree>accept(this.makeAstree()).equals(this.other.<Tree>accept(this.makeAstree()));
    }

    public Boolean visit(Mult exp) {
        return exp.<Tree>accept(this.makeAstree()).equals(this.other.<Tree>accept(this.makeAstree()));
    }

    public Boolean visit(Divd exp) {
        return exp.<Tree>accept(this.makeAstree()).equals(this.other.<Tree>accept(this.makeAstree()));
    }

    public Boolean visit(Sub exp) {
        return exp.<Tree>accept(this.makeAstree()).equals(this.other.<Tree>accept(this.makeAstree()));
    }

    public Boolean visit(Lit exp) {
        return exp.<Tree>accept(this.makeAstree()).equals(this.other.<Tree>accept(this.makeAstree()));
    }

    public Boolean visit(Add exp) {
        return exp.<Tree>accept(this.makeAstree()).equals(this.other.<Tree>accept(this.makeAstree()));
    }

    public Astree makeAstree() {
        return new Astree();
    }

    public ev.ep.Equals makeEquals(Exp _other) {
        return new ev.ep.Equals(_other);
    }
}
