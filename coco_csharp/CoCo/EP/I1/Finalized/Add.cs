namespace EP.I1.Finalized {
    public class Add : Exp, EP.I1.Add<Exp> {
        private EP.Exp<Exp> left;
        private EP.Exp<Exp> right;

        public Add(EP.Exp<Exp> _left, EP.Exp<Exp> _right) {
            this.left = _left;
            this.right = _right;
        }

        public EP.Exp<Exp> getLeft() { return this.left; }

        public EP.Exp<Exp> getRight() { return this.right; }
    }
}