package interpreter.ep.m7;

import interpreter.ep.m4.CollectSimplifyExp;
import interpreter.ep.m6.EqualsExp;

public interface PowByExp extends EqualsExp {

	PowByExp powby(PowByExp other);

	// producer methods must be present in all subsequent evolutions
	CollectSimplifyExp simplify();

	// all subsequent data types involved in Truncate must also duplicate logic to access correct lit() factory method
}
