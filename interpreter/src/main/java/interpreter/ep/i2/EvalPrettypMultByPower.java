package interpreter.ep.i2;

import interpreter.ep.i1.MultByAdd;
import interpreter.ep.i1.MultByExp;
import interpreter.ep.i1.MultByLit;

public class EvalPrettypMultByPower implements MultByExp {

    public EvalPrettypMultByPower(MultByExp left, MultByExp right) {
        this.left = left;
        this.right = right;
    }

    protected MultByExp left;
    protected MultByExp right;

    public Double eval() {
        return Math.pow(left.eval(), right.eval());
    }
    
    public String prettyp() {
    	return "(" + left.prettyp() + "^" + right.prettyp() + ")";
    }
    
    public MultByExp multby(MultByExp other) {
    	double leftEval = left.eval();
        double added = Math.log(other.eval()) / Math.log(leftEval);
        return new EvalPrettypMultByPower(left, new MultByAdd(right, new MultByLit(added)));
    }
}
