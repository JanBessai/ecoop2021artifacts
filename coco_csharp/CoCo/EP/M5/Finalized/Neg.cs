namespace EP.M5.Finalized {
    public class Neg : Exp, EP.M5.Neg<Exp> {
        private EP.Exp<Exp> inner;

        public Neg(EP.Exp<Exp> _inner) {
            this.inner = _inner;
        }

        public EP.Exp<Exp> getInner() { return this.inner; }
        public void setInner(EP.Exp<Exp> _inner) { this.inner = _inner; }
    }
}