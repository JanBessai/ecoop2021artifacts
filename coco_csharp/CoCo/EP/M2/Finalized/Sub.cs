namespace EP.M2.Finalized {
    public class Sub : Exp, EP.M2.Sub<Exp> {
        private EP.Exp<Exp> left;
        private EP.Exp<Exp> right;

        public Sub(EP.Exp<Exp> _left, EP.Exp<Exp> _right) {
            this.left = _left;
            this.right = _right;
        }

        public EP.Exp<Exp> getLeft() { return this.left; }

        public EP.Exp<Exp> getRight() { return this.right; }
    }
}