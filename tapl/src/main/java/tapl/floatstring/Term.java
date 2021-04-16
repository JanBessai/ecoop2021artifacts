package tapl.floatstring;

import java.util.Optional;

public interface Term<Elem, Tm> extends tapl.Element<Elem, Tm>, tapl.Term<Elem, Tm>, Factory<Elem, Tm> {
	default Optional<Float> matchNumber() { return Optional.empty(); }
}
