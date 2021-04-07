package interpreter.ep.i2;

import interpreter.ep.i1.MultByExp;

public class EvalPrettypMultByPower implements MultByExp {

    public EvalPrettypMultByPower(MultByExp left, MultByExp right) {
        this.left = left;
        this.right = right;
    }

    public MultByExp getLeft() {
        return this.left;
    }

    public MultByExp getRight() {
        return this.right;
    }

    protected MultByExp left;

    protected MultByExp right;

    public Double eval() {
        return Math.pow(getLeft().eval(), getRight().eval());
    }
    
    public String prettyp() {
    	return "(" + getLeft().prettyp() + "^" + getRight().prettyp() + ")";
    }
    
    public MultByExp multby(MultByExp other) {
    	return new EvalPrettypMultByPower(getLeft().multby(other), getRight().multby(other));
    }
}
