namespace EP.M2.Finalized {
    public interface Exp : Factory, EP.M2.Exp<Exp>  {
        Exp EP.Exp<Exp>.getSelf() { return this; }            
    }
}