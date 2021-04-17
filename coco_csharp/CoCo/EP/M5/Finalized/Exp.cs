namespace EP.M5.Finalized {
    public interface Exp : Factory, EP.M5.Exp<Exp>  {
        Exp EP.Exp<Exp>.getSelf() { return this; }            
    }
}