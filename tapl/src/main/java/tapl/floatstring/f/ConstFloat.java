package tapl.floatstring.f;

public class ConstFloat implements tapl.floatstring.ConstFloat<Element, Term>, Term {
    private final float number;

    public ConstFloat(float number) {
        this.number = number;
    }

    @Override
    public float getNumber() {
        return number;
    }
}
