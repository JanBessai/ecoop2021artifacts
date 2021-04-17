package tapl.lambdacalculus.f;

import tapl.varapp.Var;

import java.util.function.BiFunction;

public class LambdacalculusTests implements tapl.lambdacalculus.LambdacalculusTests<Element, Term> {
    @Override public Factory getFactory() { return new Factory() {}; }
}
