package ev.ep.m7i2;

import ev.ep.m4.Collect;

import java.util.List;

public class CollectMerged extends Collect implements VisitorMerged<List<Double>> {

    public CollectMerged() {
    }

    public List<Double> visit(ev.ep.i2.Power exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this).stream(), exp.getRight().accept(this).stream()).collect(java.util.stream.Collectors.toList());
    }

}
