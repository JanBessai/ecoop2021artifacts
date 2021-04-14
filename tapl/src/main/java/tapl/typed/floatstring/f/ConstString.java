package tapl.typed.floatstring.f;

public class ConstString implements tapl.typed.floatstring.ConstString<Element, Term, Type>, Term {
    private final String text;

    public ConstString(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
