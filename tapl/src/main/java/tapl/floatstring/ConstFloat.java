package tapl.floatstring;

import java.util.Optional;

public interface ConstFloat<Elem, Tm> extends Term<Elem, Tm> {
	float getNumber();
	
	@Override default String print() { return String.valueOf(getNumber()); }
	@Override default Optional<Float> matchNumber() { return Optional.of(getNumber()); }
}
