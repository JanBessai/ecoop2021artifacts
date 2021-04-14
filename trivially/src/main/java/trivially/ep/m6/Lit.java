package trivially.ep.m6;

public interface Lit extends Exp, trivially.ep.m5.Lit {

    Double getValue();

    default Boolean equals(Exp other) {
        return this.astree().equals(((Exp) other).astree());
    }

    default Exp simplify() {
        return this;
    }

    default Boolean isLit(Double d) {
        return d.equals(getValue());
    }

    default Boolean eql(Exp that) {
        return that.isLit(getValue());
    }
}
