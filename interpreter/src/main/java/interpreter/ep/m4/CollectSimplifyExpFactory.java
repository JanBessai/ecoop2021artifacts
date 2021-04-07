package interpreter.ep.m4;

public class CollectSimplifyExpFactory {

    public static CollectSimplifyExp Neg(CollectSimplifyExp inner) {
        return new CollectSimplifyNeg(inner);
    }

    public static CollectSimplifyExp Mult(CollectSimplifyExp left, CollectSimplifyExp right) {
        return new CollectSimplifyMult(left, right);
    }

    public static CollectSimplifyExp Divd(CollectSimplifyExp left, CollectSimplifyExp right) {
        return new CollectSimplifyDivd(left, right);
    }

    public static CollectSimplifyExp Sub(CollectSimplifyExp left, CollectSimplifyExp right) {
        return new CollectSimplifySub(left, right);
    }

    public static CollectSimplifyExp Lit(Double value) {
        return new CollectSimplifyLit(value);
    }

    public static CollectSimplifyExp Add(CollectSimplifyExp left, CollectSimplifyExp right) {
        return new CollectSimplifyAdd(left, right);
    }
}
