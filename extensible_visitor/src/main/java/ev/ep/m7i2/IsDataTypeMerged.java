package ev.ep.m7i2;

import ev.ep.Exp;

/** Use an interface because future evolutions will need to augment with their own visit methods. */
public interface IsDataTypeMerged extends ev.ep.m6.IsDataType, VisitorMerged<Boolean> {

    default Boolean visit(ev.ep.i2.Power exp) { return false; }

    default EqlMerged makeEql(Exp other) { return new EqlMerged(other); }
}
