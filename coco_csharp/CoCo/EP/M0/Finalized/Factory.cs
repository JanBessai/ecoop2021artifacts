namespace EP.M0.Finalized {
    public interface Factory : EP.M0.Factory<Exp> {
        EP.Exp<Exp> EP.M0.Factory<Exp>.lit(double value) { return new Lit(value); }
        EP.Exp<Exp> EP.M0.Factory<Exp>.add(EP.Exp<Exp> left, EP.Exp<Exp> right) { return new Add(left, right); }

        
        Exp<Exp> EP.M0.Factory<Exp>.convert(EP.Exp<Exp> other) { return other.getSelf(); }
    }
}