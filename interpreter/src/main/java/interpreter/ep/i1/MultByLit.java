package interpreter.ep.i1;

import interpreter.ep.m2.PrettypLit;

public class MultByLit extends PrettypLit implements MultByExp {

	public MultByLit(Double value) {
		super(value);
	}

    public MultByExp multby(MultByExp other) {
        MultByExp result = other;
        Double counter = Math.floor(Math.abs(value));
        while (1.0 < counter) {
            result = new MultByAdd(result, other);
            counter = counter - 1.0;
        }
        
        if (value < 0.0) {
            result = new MultBySub(new MultByLit(0.0), result);
        }
        return result;
    }
}
