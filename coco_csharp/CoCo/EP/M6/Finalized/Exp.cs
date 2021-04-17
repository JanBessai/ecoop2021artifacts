namespace EP.M6.Finalized {
    public interface Exp : Factory, EP.M6.Exp<Exp>  {
        Exp EP.Exp<Exp>.getSelf() { return this; }            
    }
}