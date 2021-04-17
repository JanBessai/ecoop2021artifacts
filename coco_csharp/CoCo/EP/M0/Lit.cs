namespace EP.M0 {
    public interface Lit<FT> : Exp<FT> {

        double getValue();

        double Exp<FT>.eval() {
            return this.getValue();
        }
    }
}