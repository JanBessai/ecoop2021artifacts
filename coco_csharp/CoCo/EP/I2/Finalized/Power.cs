namespace EP.I2.Finalized {
    public class Power : EP.I1.Finalized.Exp, EP.I2.Power<EP.I1.Finalized.Exp>, Factory {
        private EP.Exp<EP.I1.Finalized.Exp> left;
        private EP.Exp<EP.I1.Finalized.Exp> right;

        public Power(EP.Exp<EP.I1.Finalized.Exp> _left, EP.Exp<EP.I1.Finalized.Exp> _right) {
            this.left = _left;
            this.right = _right;
        }

        public EP.Exp<EP.I1.Finalized.Exp> getLeft() { return this.left; }

        public EP.Exp<EP.I1.Finalized.Exp> getRight() { return this.right; }
    }
}