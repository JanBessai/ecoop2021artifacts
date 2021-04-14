package trivially.ep.m4;

import trivially.ep.m4.finalized.Lit;
import java.util.List;

public interface Neg extends Exp, trivially.ep.m3.Neg {

    Exp getInner();

    void setInner(Exp exp);

    default Exp simplify() {
        if (Double.valueOf(this.getInner().eval()).equals(0.0)) {
            return new Lit(0.0);
        } else {
            return new trivially.ep.m4.finalized.Neg(this.getInner().simplify());
        }
    }

    default List<Double> collect() {
        return this.getInner().collect();
    }

    default void truncate (int level) {
        if (level > 1) {
            getInner().truncate(level-1);
        } else {
            setInner(new Lit(getInner().eval()));
        }
    }
}
