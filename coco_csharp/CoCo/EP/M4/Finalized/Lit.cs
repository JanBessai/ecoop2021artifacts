namespace EP.M4.Finalized {
    public class Lit : Exp, EP.M4.Lit<Exp> {
        private double value;

        public Lit(double value) {
            this.value = value;
        }
        public double getValue() {
            return this.value;
        }
    }
}