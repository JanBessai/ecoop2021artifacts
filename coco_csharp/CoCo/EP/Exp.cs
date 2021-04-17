namespace EP {
    public interface Exp<FT> : Factory<FT> {
        public FT getSelf();
    }
}