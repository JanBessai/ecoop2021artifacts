package interpreter.ep.i1;

import interpreter.ep.m2.PrettypSub;

import static interpreter.ep.i1.MultByExpFactory.*;

public class MultBySub extends PrettypSub implements MultByExp {

    public MultBySub(MultByExp left, MultByExp right) {
		super(left, right);
	}
    
    public MultByExp getLeft() {
        return (MultByExp) this.left;
    }

    public MultByExp getRight() {
        return (MultByExp) this.right;
    }

	public MultByExp multby(MultByExp other) {
        return sub(this.getLeft().multby(other), this.getRight().multby(other));
    }
}
