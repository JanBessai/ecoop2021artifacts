namespace EP.M7.Finalized {
    public class Neg : Exp, EP.M7.Neg<Exp> {
        private EP.Exp<Exp> inner;

        public Neg(EP.Exp<Exp> _inner) {
            this.inner = _inner;
        }

        public EP.Exp<Exp> getInner() { return this.inner; }
        public void setInner(EP.Exp<Exp> _inner) { this.inner = _inner; }
    }
}