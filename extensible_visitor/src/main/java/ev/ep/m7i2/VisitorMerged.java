package ev.ep.m7i2;

import ev.ep.i2.VisitorPower;
import ev.ep.m3.VisitorDivdMultNeg;

public interface VisitorMerged<R> extends VisitorDivdMultNeg<R>, VisitorPower<R> {

}
