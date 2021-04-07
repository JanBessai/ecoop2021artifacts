package interpreter.ep.i2;

import static interpreter.ep.i1.MultByExpFactory.*;

import interpreter.ep.i1.MultByAdd;
import interpreter.ep.i1.MultByExp;

public class EvalPrettypMultByAdd extends MultByAdd implements MultByExp {

    public EvalPrettypMultByAdd(MultByExp left, MultByExp right) {
		super(left, right);
	}
    
    public MultByExp getLeft() {
        return (MultByExp) this.getLeft();
    }

    public MultByExp getRight() {
        return (MultByExp) this.getRight();
    }

	public MultByExp multby(MultByExp other) {
        return Add(this.getLeft().multby(other), this.getRight().multby(other));
    }
}
