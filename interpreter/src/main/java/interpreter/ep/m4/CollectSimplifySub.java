package interpreter.ep.m4;

import static interpreter.ep.m4.CollectSimplifyExpFactory.*;

import interpreter.ep.m2.PrettypSub;

public class CollectSimplifySub extends PrettypSub implements CollectSimplifyExp {

    public CollectSimplifySub(CollectSimplifyExp left, CollectSimplifyExp right) {
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
        if (getLeft().eval() == getRight().eval()) {
            return Lit(0.0);
        } else {
            return Sub(getLeft().simplify(), getRight().simplify());
        }
    }

    public java.util.List<Double> collect() {
        java.util.List<Double> tmpList5 = new java.util.ArrayList<>();
        tmpList5.addAll(getLeft().collect());
        tmpList5.addAll(getRight().collect());
        return tmpList5;
    }

}
