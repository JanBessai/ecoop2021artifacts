package tapl.typed.nat;

public interface Zero<Elem, Tm, UNat, Ty> extends UnaryNat<Elem, Tm, UNat, Ty>, tapl.nat.Zero<Elem, Tm, UNat> {
	@Override default tapl.typed.Type<Elem, Tm, Ty> getType() { return nat(); }
}
