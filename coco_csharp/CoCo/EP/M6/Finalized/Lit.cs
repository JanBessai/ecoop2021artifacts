namespace EP.M6.Finalized {
    public class Lit : Exp, EP.M6.Lit<Exp> {
        private double value;

        public Lit(double value) {
            this.value = value;
        }
        public double getValue() {
            return this.value;
        }
    }
}