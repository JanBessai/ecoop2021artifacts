namespace EP.M3.Finalized {
    public interface Factory : EP.M3.Factory<EP.M2.Finalized.Exp>, EP.M2.Finalized.Factory {
        EP.Exp<EP.M2.Finalized.Exp> EP.M3.Factory<EP.M2.Finalized.Exp>.mult(EP.Exp<EP.M2.Finalized.Exp> left, EP.Exp<EP.M2.Finalized.Exp> right) { return new Mult(left, right); }
        EP.Exp<EP.M2.Finalized.Exp> EP.M3.Factory<EP.M2.Finalized.Exp>.divd(EP.Exp<EP.M2.Finalized.Exp> left, EP.Exp<EP.M2.Finalized.Exp> right) { return new Divd(left, right); }
        EP.Exp<EP.M2.Finalized.Exp> EP.M3.Factory<EP.M2.Finalized.Exp>.neg(EP.Exp<EP.M2.Finalized.Exp> inner) { return new Neg(inner); }
    }
}