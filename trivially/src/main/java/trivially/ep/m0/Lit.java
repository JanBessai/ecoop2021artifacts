package trivially.ep.m0;

public interface Lit extends Exp {

    Double getValue();

    default Double eval() {
        return this.getValue();
    }
}
