namespace EP.M7I2.Finalized {
    public class Lit : Exp, EP.M7I2.Lit<Exp> {
        private double value;

        public Lit(double value) {
            this.value = value;
        }
        public double getValue() {
            return this.value;
        }
    }
}