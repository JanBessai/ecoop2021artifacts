package tapl.typed;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public interface ToplevelTests<Elem, Tm, Ty> extends tapl.ToplevelTests<Elem, Tm> {
    @Override Factory<Elem, Tm, Ty> getFactory();
    @Override Term<Elem, Tm, Ty> getTerm();

    @Test
    @Override default void testFactory() {
        tapl.ToplevelTests.super.testFactory();
        Type<Elem, Tm, Ty> ty = getTerm().getType();
        assertSame(ty, getFactory().convert(ty));
    }

    @Test
    default void testType()  {
        Type<Elem, Tm, Ty> ty = getTerm().getType();
        assertSame(ty, ty.getSelfType());
        assertTrue(ty.equals(ty));
    }
}
