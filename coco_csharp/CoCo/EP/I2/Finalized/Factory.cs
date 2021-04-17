namespace EP.I2.Finalized {
    public interface Factory : EP.I2.Factory<EP.I1.Finalized.Exp>, EP.I1.Finalized.Factory {
        EP.Exp<EP.I1.Finalized.Exp> EP.I2.Factory<EP.I1.Finalized.Exp>.power(EP.Exp<EP.I1.Finalized.Exp> left, EP.Exp<EP.I1.Finalized.Exp> right) { return new Power(left, right); }
    }
}