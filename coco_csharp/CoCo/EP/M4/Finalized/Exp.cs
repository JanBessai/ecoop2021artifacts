namespace EP.M4.Finalized {
    public interface Exp : Factory, EP.M4.Exp<Exp>  {
        Exp EP.Exp<Exp>.getSelf() { return this; }            
    }
}