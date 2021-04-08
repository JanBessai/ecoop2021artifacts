package interpreter.ep.i2;

import static interpreter.ep.i1.MultByExpFactory.*;

import interpreter.ep.i1.MultByAdd;
import interpreter.ep.i1.MultByExp;

public class EvalPrettypMultByAdd extends MultByAdd implements MultByExp {

    public EvalPrettypMultByAdd(MultByExp left, MultByExp right) {
		super(left, right);
	}
    
    public MultByExp getLeft() { return (MultByExp) left; }

    public MultByExp getRight() {
        return (MultByExp) right;
    }

	public MultByExp multby(MultByExp other) {
        return add(this.getLeft().multby(other), this.getRight().multby(other));
    }
}
