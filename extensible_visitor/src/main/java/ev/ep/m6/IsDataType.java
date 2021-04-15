package ev.ep.m6;

import ev.ep.Exp;
import ev.ep.m3.VisitorDivdMultNeg;

/** USe an interface because future evolutions will need to augment with their own visit methods. */
public interface IsDataType extends VisitorDivdMultNeg<Boolean> {

    default Boolean visit(ev.ep.m0.Lit exp)  { return false; }
    default Boolean visit(ev.ep.m0.Add exp)  { return false; }
    default Boolean visit(ev.ep.m1.Sub exp)  { return false; }
    default Boolean visit(ev.ep.m3.Mult exp) { return false; }
    default Boolean visit(ev.ep.m3.Neg exp)  { return false; }
    default Boolean visit(ev.ep.m3.Divd exp) { return false; }

    default Eql makeEql(Exp other) { return new Eql(other); }
}
