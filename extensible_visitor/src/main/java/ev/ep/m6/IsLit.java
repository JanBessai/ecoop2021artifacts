package ev.ep.m6;

public class IsLit implements IsDataType {
    Double val;

    public IsLit(Double d) {
        this.val = d;
    }

    public Boolean visit(ev.ep.m0.Lit exp)  { return exp.getValue().equals(val); }
}
