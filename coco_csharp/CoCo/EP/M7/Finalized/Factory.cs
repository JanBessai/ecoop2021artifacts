namespace EP.M7.Finalized {
    public interface Factory : EP.M7.Factory<Exp> {
        EP.Exp<Exp> EP.M0.Factory<Exp>.lit(double value) { return new Lit(value); }
        EP.Exp<Exp> EP.M0.Factory<Exp>.add(EP.Exp<Exp> left, EP.Exp<Exp> right) { return new Add(left, right); }
        EP.Exp<Exp> EP.M1.Factory<Exp>.sub(EP.Exp<Exp> left, EP.Exp<Exp> right) { return new Sub(left, right); }
        EP.Exp<Exp> EP.M3.Factory<Exp>.mult(EP.Exp<Exp> left, EP.Exp<Exp> right) { return new Mult(left, right); }
        EP.Exp<Exp> EP.M3.Factory<Exp>.divd(EP.Exp<Exp> left, EP.Exp<Exp> right) { return new Divd(left, right); }
        EP.Exp<Exp> EP.M3.Factory<Exp>.neg(EP.Exp<Exp> inner) { return new Neg(inner); }
        
        EP.M7.Exp<Exp> EP.M7.Factory<Exp>.convert(EP.Exp<Exp> other) { return other.getSelf(); }
    }
}