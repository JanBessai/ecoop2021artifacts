namespace EP.I1.Finalized {
    public class Sub : Exp, EP.I1.Sub<Exp> {
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