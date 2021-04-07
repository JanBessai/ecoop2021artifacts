package interpreter.ep.i1;

public class MultByExpFactory {

    public static MultByExp Sub(MultByExp left, MultByExp right) {
        return new MultBySub(left, right);
    }

    public static MultByExp Lit(Double value) {
        return new MultByLit(value);
    }

    public static MultByExp Add(MultByExp left, MultByExp right) {
        return new MultByAdd(left, right);
    }
}
