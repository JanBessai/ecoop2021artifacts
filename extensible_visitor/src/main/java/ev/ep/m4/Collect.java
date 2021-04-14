package ev.ep.m4;

import ev.ep.m3.VisitorDivdMultNeg;

import java.util.List;

public class Collect implements VisitorDivdMultNeg<List<Double>> {

    public Collect() {
    }

    public List<Double> visit(ev.ep.m0.Lit exp) {
        return java.util.Arrays.asList(exp.getValue());
    }
    public List<Double> visit(ev.ep.m0.Add exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this).stream(), exp.getRight().accept(this).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.m1.Sub exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this).stream(), exp.getRight().accept(this).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.m3.Mult exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this).stream(), exp.getRight().accept(this).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.m3.Neg exp) {
        return exp.getInner().accept(this);
    }

    public List<Double> visit(ev.ep.m3.Divd exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this).stream(), exp.getRight().accept(this).stream()).collect(java.util.stream.Collectors.toList());
    }


}
