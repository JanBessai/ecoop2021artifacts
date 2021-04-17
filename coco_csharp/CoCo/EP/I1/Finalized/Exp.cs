namespace EP.I1.Finalized {
    public interface Exp : Factory, EP.I1.Exp<Exp>  {
        Exp EP.Exp<Exp>.getSelf() { return this; }            
    }
}