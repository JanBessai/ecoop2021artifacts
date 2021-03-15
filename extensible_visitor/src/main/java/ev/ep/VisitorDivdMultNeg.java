package ev.ep;

public interface VisitorDivdMultNeg<R> extends VisitorSub<R> {

    public abstract R visit(Neg exp);

    public abstract R visit(Mult exp);

    public abstract R visit(Divd exp);
}
