package interpreter.ep.i1;

import interpreter.ep.m2.PrettypLit;
import static interpreter.ep.i1.MultByExpFactory.*;

public class MultByLit extends PrettypLit implements MultByExp {

	public MultByLit(Double value) {
		super(value);
	}

    public Double getValue() {
        return value;
    }
    
    public MultByExp multby(MultByExp other) {
        MultByExp result = other;
        Double counter = Math.floor(Math.abs(this.getValue()));
        while (1.0 < counter) {
            result = add(result, other);
            counter = counter - 1.0;
        }
        
        if (this.getValue() < 0.0) {
            result = sub(lit(0.0), result);
        }
        return result;
    }
}
