namespace EP.M7I2.Finalized {
    public interface Exp : Factory, EP.M7I2.Exp<Exp>  {
        Exp EP.Exp<Exp>.getSelf() { return this; }            
    }
}