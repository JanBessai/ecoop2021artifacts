package trivially.ep.m7i2;

public interface Lit extends Exp, trivially.ep.m7.Lit, trivially.ep.i1.Lit {

    Double getValue();

    // unsafe casts
    default Exp powby(trivially.ep.m7.Exp other) { return new trivially.ep.m7i2.finalized.Power(this, (trivially.ep.m7i2.Exp)other); }
    default Exp multby(trivially.ep.i1.Exp other) { return  new trivially.ep.m7i2.finalized.Mult(this, (trivially.ep.m7i2.Exp)other); }

    default Exp simplify() {
        return this;
    }
}
