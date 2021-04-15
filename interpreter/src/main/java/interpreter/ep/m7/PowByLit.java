package interpreter.ep.m7;

import interpreter.ep.m6.EqualsLit;

public class PowByLit extends EqualsLit implements PowByExp {

	public PowByLit(Double value) {
		super(value);
	}

    public PowByExp simplify() { return this; }

    public PowByExp powby(PowByExp other) {
        Double exponentValue = other.eval();
        PowByExp result = this;
        Double counter = Math.floor(Math.abs(exponentValue));
        while (1.0 < counter) {
            result = new PowByMult(result, this);
            counter = counter - 1.0;
        }
        if (this.getValue() < 0.0) {
            result = new PowByDivd(new PowByLit(1.0), result);
        }
        return result;
    }
    
}
