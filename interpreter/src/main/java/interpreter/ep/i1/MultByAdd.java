package interpreter.ep.i1;

import interpreter.ep.m2.PrettypAdd;
import static interpreter.ep.i1.MultByExpFactory.*;

public class MultByAdd extends PrettypAdd implements MultByExp {

    public MultByAdd(MultByExp left, MultByExp right) {
		super(left, right);
	}
    
    public MultByExp getLeft() {
        return (MultByExp) this.left;
    }

    public MultByExp getRight() {
        return (MultByExp) this.right;
    }

    /** Distribute Multiplication to arguments. */
	public MultByExp multby(MultByExp other) {
        return Add(this.getLeft().multby(other), this.getRight().multby(other));
    }
}
