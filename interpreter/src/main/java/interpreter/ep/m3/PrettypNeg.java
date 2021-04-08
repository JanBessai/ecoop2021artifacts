package interpreter.ep.m3;

import interpreter.ep.m2.PrettypExp;

public class PrettypNeg implements PrettypExp {

    public PrettypNeg(PrettypExp inner) {
    	this.inner = inner;
    }

    protected PrettypExp inner;

    public PrettypExp getInner() {
        return this.inner;
    }

    public Double eval() {
        return -getInner().eval();
    }

    public String prettyp() {
        return "(-" + getInner().prettyp() + ")";
    }
}
