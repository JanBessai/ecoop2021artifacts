namespace EP.I1.Finalized {
    public class Lit : Exp, EP.I1.Lit<Exp> {
        private double value;

        public Lit(double value) {
            this.value = value;
        }
        public double getValue() {
            return this.value;
        }
    }
}