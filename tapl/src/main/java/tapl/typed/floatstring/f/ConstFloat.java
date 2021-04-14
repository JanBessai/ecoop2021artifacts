package tapl.typed.floatstring.f;

public class ConstFloat implements tapl.typed.floatstring.ConstFloat<Element, Term, Type>, Term {
    private final float number;

    public ConstFloat(float number) {
        this.number = number;
    }

    @Override
    public float getNumber() {
        return number;
    }
}
