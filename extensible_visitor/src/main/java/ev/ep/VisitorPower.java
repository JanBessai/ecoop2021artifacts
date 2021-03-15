package ev.ep;

public interface VisitorPower<R> extends VisitorDivdMultNeg<R> {

    public abstract R visit(Power exp);
}
