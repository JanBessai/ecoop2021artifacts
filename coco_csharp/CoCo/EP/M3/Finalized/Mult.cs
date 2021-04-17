namespace EP.M3.Finalized {
    public class Mult : EP.M2.Finalized.Exp, EP.M3.Mult<EP.M2.Finalized.Exp>, Factory {
        private EP.Exp<EP.M2.Finalized.Exp> left;
        private EP.Exp<EP.M2.Finalized.Exp> right;

        public Mult(EP.Exp<EP.M2.Finalized.Exp> _left, EP.Exp<EP.M2.Finalized.Exp> _right) {
            this.left = _left;
            this.right = _right;
        }

        public EP.Exp<EP.M2.Finalized.Exp> getLeft() { return this.left; }

        public EP.Exp<EP.M2.Finalized.Exp> getRight() { return this.right; }
    }
}