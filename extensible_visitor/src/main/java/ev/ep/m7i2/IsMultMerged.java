package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.m6.IsMult;

public class IsMultMerged extends IsMult implements IsDataTypeMerged {

    public IsMultMerged(Exp _left, Exp _right) {
       super(_left, _right);
    }

}
