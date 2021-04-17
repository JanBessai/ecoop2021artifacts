namespace EP.M5.Finalized {
    public class Lit : Exp, EP.M5.Lit<Exp> {
        private double value;

        public Lit(double value) {
            this.value = value;
        }
        public double getValue() {
            return this.value;
        }
    }
}