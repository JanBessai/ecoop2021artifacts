package interpreter.ep.i1;

import interpreter.ep.m2.PrettypAdd;

public class MultByAdd extends PrettypAdd implements MultByExp {

    public MultByAdd(MultByExp left, MultByExp right) {
		super(left, right);
	}

    /** Distribute Multiplication to arguments. */
	public MultByExp multby(MultByExp other) { return new MultByAdd(((MultByExp)left).multby(other), ((MultByExp)right).multby(other));  }
}
