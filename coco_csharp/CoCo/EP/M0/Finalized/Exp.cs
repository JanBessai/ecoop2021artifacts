namespace EP.M0.Finalized {
    public interface Exp : Factory, EP.M0.Exp<Exp>  {
        Exp EP.Exp<Exp>.getSelf() { return this; }            
    }
}