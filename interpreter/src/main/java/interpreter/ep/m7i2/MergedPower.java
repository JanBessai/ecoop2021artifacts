package interpreter.ep.m7i2;

import interpreter.ep.i2.EvalPrettypMultByPower;
import interpreter.ep.m6.EqualsExp;
import interpreter.ep.m7.PowByExp;

import static interpreter.ep.m7i2.MergedExpFactory.*;

import interpreter.ep.i1.MultByExp;

/** This must extend from I2 branch since Power comes from there. */
public class MergedPower extends EvalPrettypMultByPower implements MergedExp {

	public MergedPower(MergedExp left, MergedExp right) {
		super(left, right);
	}

	public MergedExp getLeft() {
		return (MergedExp) super.getLeft();
	}

	public MergedExp getRight() {
		return (MergedExp) super.getRight();
	}

	/** Take advantage of results from both branches. */
	@Override
	public MergedExp multby(MultByExp other) {
        return mult(this, (MergedExp) other);
    }
	
	/** Take advantage of results from both branches. */
	@Override
	public MergedExp powby(PowByExp other) {
		return power(this, (MergedExp)other);
	}

	/** Cannot covariantly overide the parameter to the method. */
	@Override
	public Boolean equals(EqualsExp that) {
		return this.astree().equals(that.astree());
	}

	public Boolean isPower(MergedExp left, MergedExp right) { 
		return left.eql(getLeft()) && right.eql(getRight()); 
	}

	public Boolean eql(EqualsExp that) {
		return ((MergedExp)that).isPower(getLeft(), getRight());
	}

	@Override
	public util.Tree astree() {
		return new util.Node(this.idz(), getLeft().astree(), getRight().astree());
	}

	@Override
	public Integer idz() {
		return 13978;
	}

	void setLeft(MergedExp left) { 
		this.left = left;
	}
	void setRight(MergedExp right) { 
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

	@Override
	public MergedExp simplify() {
		double leftVal = getLeft().eval();
		double rightVal = getRight().eval();
		if (leftVal == 1) {
			return lit(1.0);
		} else if (rightVal == 0) {
			return lit(1.0);
		} else if (rightVal == 1) {
			return getLeft().simplify();
		} else {
			return power(getLeft().simplify(), getRight().simplify());
		}
	}

	@Override
	public java.util.List<Double> collect() {
		java.util.List<Double> tmpList4 = new java.util.ArrayList<>();
		tmpList4.addAll(getLeft().collect());
		tmpList4.addAll(getRight().collect());
		return tmpList4;
	}
}
