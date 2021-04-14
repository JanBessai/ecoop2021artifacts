package tapl.floatstring.f;

public class ConstString implements tapl.floatstring.ConstString<Element, Term>, Term {
    private final String text;

    public ConstString(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
