package interpreter.ep.m4;

public class CollectSimplifyExpFactory {

    public static CollectSimplifyExp neg(CollectSimplifyExp inner) {
        return new CollectSimplifyNeg(inner);
    }

    public static CollectSimplifyExp mult(CollectSimplifyExp left, CollectSimplifyExp right) {
        return new CollectSimplifyMult(left, right);
    }

    public static CollectSimplifyExp divd(CollectSimplifyExp left, CollectSimplifyExp right) {
        return new CollectSimplifyDivd(left, right);
    }

    public static CollectSimplifyExp sub(CollectSimplifyExp left, CollectSimplifyExp right) {
        return new CollectSimplifySub(left, right);
    }

    public static CollectSimplifyExp lit(Double value) {
        return new CollectSimplifyLit(value);
    }

    public static CollectSimplifyExp add(CollectSimplifyExp left, CollectSimplifyExp right) {
        return new CollectSimplifyAdd(left, right);
    }
}
