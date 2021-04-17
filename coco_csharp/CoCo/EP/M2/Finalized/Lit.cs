namespace EP.M2.Finalized {
    public class Lit : Exp, EP.M2.Lit<Exp> {
        private double value;

        public Lit(double value) {
            this.value = value;
        }
        public double getValue() {
            return this.value;
        }
    }
}