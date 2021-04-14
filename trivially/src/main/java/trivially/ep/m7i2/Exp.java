package trivially.ep.m7i2;

public interface Exp extends trivially.ep.m7.Exp, trivially.ep.i1.Exp {

    // need all because producers
    trivially.ep.m7i2.Exp multby(trivially.ep.i1.Exp other);

    trivially.ep.m7i2.Exp simplify();

    trivially.ep.m7i2.Exp powby(trivially.ep.m7.Exp other);

    // don't forget the truncates in new data types

    // new data type to combine with eql
    default Boolean isPower(trivially.ep.m7i2.Exp left, trivially.ep.m7i2.Exp right) { return false; }
}
