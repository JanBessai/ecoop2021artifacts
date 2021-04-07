package interpreter.ep.m3;

import interpreter.ep.m2.PrettypExp;

public class PrettypDivd implements PrettypExp {

    public PrettypDivd(PrettypExp left, PrettypExp right) {
    	this.left = left;
        this.right = right;
    }

    protected PrettypExp left;

    protected PrettypExp right;
    
    public PrettypExp getLeft() {
        return this.left;
    }

    public PrettypExp getRight() {
        return this.right;
    }

    public Double eval() {
        return getLeft().eval() / getRight().eval();
    }

    public String prettyp() {
        return "(" + getLeft().prettyp() + "/" + getRight().prettyp() + ")";
    }
}
