namespace EP.M3.Finalized {
    public class Neg : EP.M2.Finalized.Exp, EP.M3.Neg<EP.M2.Finalized.Exp>, Factory {
        private EP.Exp<EP.M2.Finalized.Exp> inner;

        public Neg(EP.Exp<EP.M2.Finalized.Exp> _inner) {
            this.inner = _inner;
        }

        public EP.Exp<EP.M2.Finalized.Exp> getInner() { return this.inner; }
    }
}