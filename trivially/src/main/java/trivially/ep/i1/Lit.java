package trivially.ep.i1;

import trivially.ep.i1.finalized.Add;
import trivially.ep.i1.finalized.Sub;

public interface Lit extends Exp, trivially.ep.m2.Lit {

    Double getValue();

    default Exp multby(Exp other) {
        Exp result = ((Exp) other);
        Double counter = Math.floor(Math.abs(this.getValue()));
        while (1.0 < counter) {
            result = new Add(result, ((Exp) other));
            counter = counter - 1.0;
        }
        if (this.getValue() < 0.0) {
            result = new Sub(new trivially.ep.i1.finalized.Lit(0.0), result);
        }
        return result;
    }
}
