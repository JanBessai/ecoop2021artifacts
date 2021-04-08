package trivially.ep.m2;

public interface Lit<V> extends trivially.ep.m1.Lit<V>, Exp<V> {

    Double getValue();

    default String prettyp() {
        return String.valueOf(this.getValue());
    }
}
