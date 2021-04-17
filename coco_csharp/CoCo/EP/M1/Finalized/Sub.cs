namespace EP.M1.Finalized {
    public class Sub : EP.M0.Finalized.Exp, EP.M1.Sub<EP.M0.Finalized.Exp>, Factory {
        private EP.Exp<EP.M0.Finalized.Exp> left;
        private EP.Exp<EP.M0.Finalized.Exp> right;

        public Sub(EP.Exp<EP.M0.Finalized.Exp> _left, EP.Exp<EP.M0.Finalized.Exp> _right) {
            this.left = _left;
            this.right = _right;
        }

        public EP.Exp<EP.M0.Finalized.Exp> getLeft() { return this.left; }

        public EP.Exp<EP.M0.Finalized.Exp> getRight() { return this.right; }
    }
}