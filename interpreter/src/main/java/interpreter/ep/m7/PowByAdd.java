package interpreter.ep.m7;

import interpreter.ep.m6.EqualsAdd;

import static interpreter.ep.m7.PowByExpFactory.*;

public class PowByAdd extends EqualsAdd implements PowByExp {

    public PowByAdd(PowByExp left, PowByExp right) {
		super(left, right);
	}
    
    public PowByExp getLeft() {
        return (PowByExp) this.left;
    }

    public PowByExp getRight() {
        return (PowByExp) this.right;
    }

	public PowByExp powby(PowByExp other) {
        return Add(this.getLeft().powby(other), this.getRight().powby(other));
    }
}
