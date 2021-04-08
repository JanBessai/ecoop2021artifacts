package interpreter.ep.m7;

import interpreter.ep.m6.EqualsNeg;

import static interpreter.ep.m7.PowByExpFactory.*;

public class PowByNeg extends EqualsNeg implements PowByExp {

    public PowByNeg(PowByExp inner) {
		super(inner);
	}
    
    public PowByExp getInner() {
        return (PowByExp) this.inner;
    }

	public PowByExp powby(PowByExp other) {
        return mult(lit(1.0).powby(getInner()), getInner().powby(other));
    }
}
