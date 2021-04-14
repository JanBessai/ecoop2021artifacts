package trivially.ep.m2;

public interface Lit extends Exp, trivially.ep.m0.Lit {

    Double getValue();

    default String prettyp() {
        return String.valueOf(this.getValue());
    }
}
