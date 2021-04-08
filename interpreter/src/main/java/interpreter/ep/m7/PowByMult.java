package interpreter.ep.m7;

import interpreter.ep.m6.EqualsMult;

import static interpreter.ep.m7.PowByExpFactory.*;

public class PowByMult extends EqualsMult implements PowByExp {

    public PowByMult(PowByExp left, PowByExp right) {
		super(left, right);
	}
    
    public PowByExp getLeft() {
        return (PowByExp) this.left;
    }

    public PowByExp getRight() {
        return (PowByExp) this.right;
    }

	public PowByExp powby(PowByExp other) {
        return mult(this.getLeft().powby(other), this.getRight().powby(other));
    }
}
