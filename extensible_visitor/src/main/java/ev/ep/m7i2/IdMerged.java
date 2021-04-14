package ev.ep.m7i2;

import ev.ep.i2.Power;
import ev.ep.m5.Id;

public class IdMerged extends Id implements VisitorMerged<Integer> {

    public IdMerged() {
    }

    public Integer visit(Power exp) { return 77306085; }

}
