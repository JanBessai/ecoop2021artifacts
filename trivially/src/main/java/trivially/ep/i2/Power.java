package trivially.ep.i2;

import trivially.ep.i1.Exp;
import trivially.ep.i1.finalized.Add;
import trivially.ep.i1.finalized.Lit;

public interface Power extends Exp {

    Exp getLeft();

    Exp getRight();

    default String prettyp() {
        return "(" + this.getLeft().prettyp() + "^" + this.getRight().prettyp() + ")";
    }

    default Exp multby(Exp other) {
        double leftEval =this.getLeft().eval();
        double added = Math.log(other.eval()) / Math.log(leftEval);
        return new trivially.ep.i2.finalized.Power(this.getLeft(), new Add(this.getRight(), new Lit(added)));
    }

    default Double eval() {
        return Math.pow(this.getLeft().eval(), this.getRight().eval());
    }
}
