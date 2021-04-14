package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.i2.VisitorPower;
import ev.ep.i2.Power;
import ev.ep.m6.Equals;

public class EqualsMerged extends Equals implements VisitorPower<Boolean> {

    public EqualsMerged(Exp _other) { super(_other); }

    public Boolean visit(Power exp) {
        return exp.accept(this.makeAstree()).equals(this.other.accept(this.makeAstree()));
    }

    public AstreeMerged makeAstree() {
        return new AstreeMerged();
    }

}
