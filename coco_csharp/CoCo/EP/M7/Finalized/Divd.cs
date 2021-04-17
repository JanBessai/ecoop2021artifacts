namespace EP.M7.Finalized {
    public class Divd : Exp, EP.M7.Divd<Exp> {
        private EP.Exp<Exp> left;
        private EP.Exp<Exp> right;

        public Divd(EP.Exp<Exp> _left, EP.Exp<Exp> _right) {
            this.left = _left;
            this.right = _right;
        }

        public EP.Exp<Exp> getLeft() { return this.left; }
        public void setLeft(EP.Exp<Exp> _left) { this.left = _left; }

        public EP.Exp<Exp> getRight() { return this.right; }
        public void setRight(EP.Exp<Exp> _right) { this.right = _right; }
    }
}