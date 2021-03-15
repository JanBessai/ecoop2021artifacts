package ev.ep;

public interface Visitor<R> {

    public abstract R visit(Lit exp);

    public abstract R visit(Add exp);
}
