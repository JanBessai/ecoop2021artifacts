package ev.ep;

import util.Tree;

public class EqualsPower implements VisitorPower<Boolean> {

    protected Exp other;

    public EqualsPower(Exp _other) {
        this.other = _other;
    }

    public Boolean visit(Power exp) {
        return exp.<Tree>accept(this.makeAstree()).equals(this.other.<Tree>accept(this.makeAstree()));
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

    public AstreePower makeAstree() {
        return new AstreePower();
    }

    public ev.ep.EqualsPower makeEquals(Exp _other) {
        return new ev.ep.EqualsPower(_other);
    }
}
