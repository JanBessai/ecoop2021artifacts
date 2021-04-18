package interpreter.ep.m7i2;

import interpreter.ep.i2.EvalPrettypMultByPower;
import interpreter.ep.m6.EqualsExp;
import interpreter.ep.m7.PowByExp;

import interpreter.ep.i1.MultByExp;

/** This must extend from I2 branch since Power comes from there. */
public class MergedPower extends EvalPrettypMultByPower implements MergedExp {

	public MergedPower(MergedExp left, MergedExp right) {
		super(left, right);
	}

	/** Cannot covariantly override the parameter to the method. */
	@Override
	public Boolean equals(EqualsExp that) {
		return this.astree().equals(that.astree());
	}

	public Boolean isPower(MergedExp left, MergedExp right) { 
		return left.eql(left) && right.eql(right);
	}

	public Boolean eql(EqualsExp that) { return ((MergedExp)that).isPower((MergedExp)left, (MergedExp)right); }

	@Override
	public util.Tree astree() { return new util.Node(this.idz(), ((MergedExp)left).astree(), ((MergedExp)right).astree()); }

	@Override
	public Integer idz() {
		return 13978;
	}

	@Override
	public MergedExp simplify() {
		double leftVal = left.eval();
		double rightVal = right.eval();
		if (leftVal == 1) {
			return new MergedLit(1.0);
		} else if (rightVal == 0) {
			return new MergedLit(1.0);
		} else if (rightVal == 1) {
			return ((MergedExp)left).simplify();
		} else {
			return new MergedPower(((MergedExp)left).simplify(), ((MergedExp)right).simplify());
		}
	}

	public void truncate (int level) {
		if (level > 1) {
			((MergedExp)left).truncate(level-1);
			((MergedExp)right).truncate(level-1);
		} else {
			left = new MergedLit(left.eval());
			right = new MergedLit(right.eval());
		}
	}

	@Override
	public java.util.List<Double> collect() {
		java.util.List<Double> tmpList4 = new java.util.ArrayList<>();
		tmpList4.addAll(((MergedExp)left).collect());
		tmpList4.addAll(((MergedExp)right).collect());
		return tmpList4;
	}

	/** Take advantage of results from both branches. */
	@Override
	public MergedExp multby(MultByExp other) {
		return new MergedMult(this, (MergedExp) other);
	}

	/** Take advantage of results from both branches. */
	@Override
	public MergedExp powby(PowByExp other) {
		return new MergedPower(this, (MergedExp)other);
	}
}
