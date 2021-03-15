package ev.ep;

public abstract class Exp {

    public abstract <R> R accept(Visitor<R> v);
}
