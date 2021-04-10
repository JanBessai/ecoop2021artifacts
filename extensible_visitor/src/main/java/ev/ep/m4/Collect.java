package ev.ep.m4;

import java.util.List;

public class Collect implements VisitorDivdMultNegTruncate<List<Double>> {

    public Collect() {
    }

    // unsafe runtime exceptions
    public List<Double> visit(ev.ep.m0.Lit exp) {
        return visit((ev.ep.m4.Lit)exp);
    }
    public List<Double> visit(ev.ep.m0.Add exp) {
        return visit((ev.ep.m4.Add)exp);
    }
    public List<Double> visit(ev.ep.m1.Sub exp) {
        return visit((ev.ep.m4.Sub)exp);
    }
    public List<Double> visit(ev.ep.m3.Neg exp) {
        return visit((ev.ep.m4.Neg)exp);
    }
    public List<Double> visit(ev.ep.m3.Divd exp) {
        return visit((ev.ep.m4.Divd)exp);
    }
    public List<Double> visit(ev.ep.m3.Mult exp) {
        return visit((ev.ep.m4.Mult)exp);
    }

    public List<Double> visit(Neg exp) {
        return exp.getInner().accept(this.makeCollect());
    }

    public List<Double> visit(Mult exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public List<Double> visit(Divd exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public List<Double> visit(Sub exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public List<Double> visit(Lit exp) {
        return java.util.Arrays.asList(exp.getValue());
    }

    public List<Double> visit(Add exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public Collect makeCollect() {
        return new Collect();
    }
}
