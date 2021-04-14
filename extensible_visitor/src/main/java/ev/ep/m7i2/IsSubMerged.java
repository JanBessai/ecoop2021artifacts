package ev.ep.m7i2;

import ev.ep.Exp;
import ev.ep.m6.IsDataType;
import ev.ep.m6.IsSub;

public class IsSubMerged extends IsSub implements IsDataTypeMerged {

    public IsSubMerged(Exp _left, Exp _right) {
        super(_left, _right);
    }
}
