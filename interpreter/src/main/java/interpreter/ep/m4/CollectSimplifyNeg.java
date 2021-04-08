package interpreter.ep.m4;

import static interpreter.ep.m4.CollectSimplifyExpFactory.*;

import interpreter.ep.m3.PrettypNeg;

public class CollectSimplifyNeg extends PrettypNeg implements CollectSimplifyExp {

    public CollectSimplifyNeg(CollectSimplifyExp inner) {
        super(inner);
    }

    public CollectSimplifyExp getInner() {
        return (CollectSimplifyExp) this.inner;
    }

    void setInner(CollectSimplifyExp inner) { 
    	this.inner = inner; 
    }
    
	public void truncate (int level) {
		if (level > 1) {
			getInner().truncate(level-1);
		} else {
			setInner(lit(getInner().eval()));
		}
	}
    
    public CollectSimplifyExp simplify() {
        if (getInner().eval() == 0) {
            return lit(0.0);
        } else {
            return neg(getInner().simplify());
        }
    }

    public java.util.List<Double> collect() {
        java.util.List<Double> tmpList2 = new java.util.ArrayList<>();
        tmpList2.addAll(getInner().collect());
        return tmpList2;
    }
}
