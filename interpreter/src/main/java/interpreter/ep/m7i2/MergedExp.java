package interpreter.ep.m7i2;

import interpreter.ep.i1.MultByExp;
import interpreter.ep.m7.PowByExp;

public interface MergedExp extends PowByExp, MultByExp {

	MultByExp multby(MultByExp other);
	PowByExp powby(PowByExp other);
	
    default Boolean isPower(MergedExp left, MergedExp right) { return false; }

	// producer methods must be present in all subsequent evolutions
	MergedExp simplify();

	// all subsequent data types involved in Truncate must also duplicate logic to access correct lit() factory method
}
