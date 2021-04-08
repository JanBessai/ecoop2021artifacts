package interpreter.ep.m7;

import interpreter.ep.m6.EqualsDivd;

import static interpreter.ep.m7.PowByExpFactory.*;

public class PowByDivd extends EqualsDivd implements PowByExp {

    public PowByDivd(PowByExp left, PowByExp right) {
		super(left, right);
	}
    
    public PowByExp getLeft() {
        return (PowByExp) this.left;
    }

    public PowByExp getRight() { return (PowByExp) this.right;  }

	public PowByExp powby(PowByExp other) {
        return divd(this.getLeft().powby(other), this.getRight().powby(other));
    }
}
