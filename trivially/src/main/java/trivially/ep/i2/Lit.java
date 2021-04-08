package trivially.ep.i2;

public interface Lit<V> extends trivially.ep.i1.Lit<V>, Exp<V> {

    Double getValue();

    default Exp<V> multby(trivially.ep.Exp<V> other) {
        Exp<V> result = convert(other);
        Double counter = Math.floor(Math.abs(this.getValue()));
        while (1.0 < counter) {
            result = this.add(result, convert(other));
            counter = counter - 1.0;
        }
        if (this.getValue() < 0.0) {
            result = this.sub(this.lit(0.0), result);
        }
        return result;
    }
}
