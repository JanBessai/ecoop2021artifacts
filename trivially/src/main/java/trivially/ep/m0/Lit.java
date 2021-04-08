package trivially.ep.m0;

public interface Lit<V> extends Exp<V> {

    Double getValue();

    default Double eval() {
        return this.getValue();
    }
}
