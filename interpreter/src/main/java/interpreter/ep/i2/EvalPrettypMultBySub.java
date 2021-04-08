package interpreter.ep.i2;

import static interpreter.ep.i1.MultByExpFactory.*;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.i1.MultBySub;

public class EvalPrettypMultBySub extends MultBySub implements MultByExp {

    public EvalPrettypMultBySub(MultByExp left, MultByExp right) {
		super(left, right);
	}
    
    public MultByExp getLeft() {
        return (MultByExp) this.getLeft();
    }

    public MultByExp getRight() {
        return (MultByExp) this.getRight();
    }

	public MultByExp multby(MultByExp other) {
        return sub(this.getLeft().multby(other), this.getRight().multby(other));
    }
}
