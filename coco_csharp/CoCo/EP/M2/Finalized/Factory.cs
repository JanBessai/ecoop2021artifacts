namespace EP.M2.Finalized {
    public interface Factory : EP.M2.Factory<Exp> {
        EP.Exp<Exp> EP.M0.Factory<Exp>.lit(double value) { return new Lit(value); }
        EP.Exp<Exp> EP.M0.Factory<Exp>.add(EP.Exp<Exp> left, EP.Exp<Exp> right) { return new Add(left, right); }
        EP.Exp<Exp> EP.M1.Factory<Exp>.sub(EP.Exp<Exp> left, EP.Exp<Exp> right) { return new Sub(left, right); }

        
        EP.M2.Exp<Exp> EP.M2.Factory<Exp>.convert(EP.Exp<Exp> other) { return other.getSelf(); }
    }
}