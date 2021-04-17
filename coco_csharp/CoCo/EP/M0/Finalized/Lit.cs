namespace EP.M0.Finalized {
    public class Lit : Exp, EP.M0.Lit<Exp> {
        private double value;

        public Lit(double value) {
            this.value = value;
        }
        public double getValue() {
            return this.value;
        }
    }
}