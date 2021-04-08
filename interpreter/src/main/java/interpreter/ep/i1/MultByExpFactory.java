package interpreter.ep.i1;

public class MultByExpFactory {

    public static MultByExp lit(Double value) {
        return new MultByLit(value);
    }

    public static MultByExp add(MultByExp left, MultByExp right) {
        return new MultByAdd(left, right);
    }

    public static MultByExp sub(MultByExp left, MultByExp right) {
        return new MultBySub(left, right);
    }
}
