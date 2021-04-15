package trivially.ep.m7;

import trivially.ep.m7.finalized.Divd;
import trivially.ep.m7.finalized.Mult;

public interface Lit extends Exp, trivially.ep.m6.Lit {

    Double getValue();

    default Exp powby(Exp other) {
        Double exponentValue = other.eval();
        Exp result = this;
        double counter = Math.floor(Math.abs(exponentValue));
        while (1.0 < counter) {
            result = new Mult(result, this);
            counter = counter - 1.0;
        }
        if (this.getValue() < 0.0) {
            result = new Divd(new trivially.ep.m7.finalized.Lit(1.0), result);
        }
        return result;
    }

    default Exp simplify() {
        return this;
    }
}
