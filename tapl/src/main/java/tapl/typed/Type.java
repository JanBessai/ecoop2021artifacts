package tapl.typed;


public interface Type<Elem, Tm, Ty> extends tapl.Element<Elem, Tm>, Factory<Elem, Tm, Ty> {
    Ty getSelfType();

    boolean equals(Type<Elem, Tm, Ty> other);
}
