package interpreter.ep.i1;

import interpreter.ep.m2.PrettypSub;

public class MultBySub extends PrettypSub implements MultByExp {

    public MultBySub(MultByExp left, MultByExp right) {
		super(left, right);
	}

	public MultByExp multby(MultByExp other) { return new MultBySub(((MultByExp)left).multby(other), ((MultByExp)right).multby(other)); }
}
