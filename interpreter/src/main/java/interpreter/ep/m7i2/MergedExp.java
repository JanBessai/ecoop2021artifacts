package interpreter.ep.m7i2;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.m7.PowByExp;

public interface MergedExp extends PowByExp, MultByExp {

	/** Announce to the world that covariant override is done. */
	MergedExp simplify();

	/** Announce to the world that covariant override is done. */
	MergedExp multby(MultByExp other);
	MergedExp powby(PowByExp other);
	
    default Boolean isPower(MergedExp left, MergedExp right) { return false; }
}
