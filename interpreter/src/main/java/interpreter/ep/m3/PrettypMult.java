package interpreter.ep.m3;

import interpreter.ep.m2.PrettypExp;

public class PrettypMult implements PrettypExp {

    public PrettypMult(PrettypExp left, PrettypExp right) {
    	this.left = left;
        this.right = right;
    }

    protected PrettypExp left;
    protected PrettypExp right;
    
    public Double eval() {
        return left.eval() * right.eval();
    }

    public String prettyp() {
        return "(" +left.prettyp() + "*" + right.prettyp() + ")";
    }
}
