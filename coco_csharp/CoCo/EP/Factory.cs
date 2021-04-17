namespace EP {
    public interface Factory<FT> {
        public Exp<FT> convert(Exp<FT> other);
    }
}