package interpreter.ep.m4;

import interpreter.ep.m2.PrettypAdd;
import static interpreter.ep.m4.CollectSimplifyExpFactory.*;

public class CollectSimplifyAdd extends PrettypAdd implements CollectSimplifyExp {

    public CollectSimplifyAdd(CollectSimplifyExp left, CollectSimplifyExp right) {
        super(left, right);
    }

    public CollectSimplifyExp getLeft() {
        return (CollectSimplifyExp) this.left;
    }

    public CollectSimplifyExp getRight() {
        return (CollectSimplifyExp) this.right;
    }

    void setLeft(CollectSimplifyExp left) { 
    	this.left = left;
    }
	void setRight(CollectSimplifyExp right) { 
		this.right = right;
	}
	
	public void truncate (int level) {
		if (level > 1) {
			getLeft().truncate(level-1);
			getRight().truncate(level-1);
		} else {
			setLeft(lit(getLeft().eval()));
			setRight(lit(getRight().eval()));
		}
	}
    
    public CollectSimplifyExp simplify() {
        double leftVal = getLeft().eval();
        double rightVal = getRight().eval();
        if ((leftVal == 0 && rightVal == 0) || (leftVal + rightVal == 0)) {
            return lit(0.0);
        } else if (leftVal == 0) {
            return getRight().simplify();
        } else if (rightVal == 0) {
            return getLeft().simplify();
        } else {
            return add(getLeft().simplify(), getRight().simplify());
        }
    }

    public java.util.List<Double> collect() {
        java.util.List<Double> tmpList7 = new java.util.ArrayList<>();
        tmpList7.addAll(getLeft().collect());
        tmpList7.addAll(getRight().collect());
        return tmpList7;
    }
}
