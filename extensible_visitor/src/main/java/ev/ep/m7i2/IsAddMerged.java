package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.m6.IsAdd;
import ev.ep.m6.IsDataType;

public class IsAddMerged extends IsAdd implements IsDataTypeMerged {
    public IsAddMerged(Exp _left, Exp _right) {
       super(_left, _right);
    }

}
