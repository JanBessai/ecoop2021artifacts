package tapl.typed.bool;

public interface Type<Elem, Tm, Ty> extends tapl.typed.Type<Elem, Tm, Ty>, tapl.typed.bool.Factory<Elem, Tm, Ty> {
    default boolean isBool() { return false; }
}
