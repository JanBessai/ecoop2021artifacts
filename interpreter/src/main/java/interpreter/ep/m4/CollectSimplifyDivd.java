package interpreter.ep.m4;

import static interpreter.ep.m4.CollectSimplifyExpFactory.*;

import interpreter.ep.m3.PrettypDivd;

public class CollectSimplifyDivd extends PrettypDivd implements CollectSimplifyExp {

    public CollectSimplifyDivd(CollectSimplifyExp left, CollectSimplifyExp right) {
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
			setLeft(Lit(getLeft().eval()));
			setRight(Lit(getRight().eval()));
		}
	}
    
    public CollectSimplifyExp simplify() {
        double leftVal = getLeft().eval();
        double rightVal = getRight().eval();
        if (leftVal == 0) {
            return Lit(0.0);
        } else if (rightVal == 1) {
            return getLeft().simplify();
        } else if (leftVal == rightVal) {
            return Lit(1.0);
        } else if (leftVal == -rightVal) {
            return Lit(-1.0);
        } else {
            return Divd(getLeft().simplify(), getRight().simplify());
        }
    }

    public java.util.List<Double> collect() {
        java.util.List<Double> tmpList4 = new java.util.ArrayList<>();
        tmpList4.addAll(getLeft().collect());
        tmpList4.addAll(getRight().collect());
        return tmpList4;
    }
}
