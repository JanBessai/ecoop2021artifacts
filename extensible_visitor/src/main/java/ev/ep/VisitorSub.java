package ev.ep;

public interface VisitorSub<R> extends Visitor<R> {

    public abstract R visit(Sub exp);
}
