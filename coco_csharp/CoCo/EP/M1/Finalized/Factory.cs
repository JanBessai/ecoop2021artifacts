namespace EP.M1.Finalized {
    public interface Factory : EP.M1.Factory<EP.M0.Finalized.Exp>, EP.M0.Finalized.Factory {
        EP.Exp<EP.M0.Finalized.Exp> EP.M1.Factory<EP.M0.Finalized.Exp>.sub(EP.Exp<EP.M0.Finalized.Exp> left, EP.Exp<EP.M0.Finalized.Exp> right) { return new Sub(left, right); }
    }
}