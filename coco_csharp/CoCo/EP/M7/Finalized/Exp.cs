namespace EP.M7.Finalized {
    public interface Exp : Factory, EP.M7.Exp<Exp>  {
        Exp EP.Exp<Exp>.getSelf() { return this; }            
    }
}