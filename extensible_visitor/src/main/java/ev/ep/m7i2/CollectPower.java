package ev.ep.m7i2;

import java.util.List;

public class CollectPower implements VisitorMerged<List<Double>> {

    public CollectPower() {
    }

    public List<Double> visit(ev.ep.m7i2.Power exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.i2.Power exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public List<Double> visit(ev.ep.m7i2.Neg exp) {
        return exp.getInner().accept(this.makeCollect());
    }
    public List<Double> visit(ev.ep.m4.Neg exp) {
        return exp.getInner().accept(this.makeCollect());
    }
    public List<Double> visit(ev.ep.m3.Neg exp) {
        return exp.getInner().accept(this.makeCollect());
    }

    public List<Double> visit(ev.ep.m7i2.Mult exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.m4.Mult exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.m3.Mult exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public List<Double> visit(ev.ep.m7i2.Divd exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.m4.Divd exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.m3.Divd exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public List<Double> visit(ev.ep.m7i2.Sub exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.m4.Sub exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.m1.Sub exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public List<Double> visit(ev.ep.m7i2.Lit exp) {
        return java.util.Arrays.asList(exp.getValue());
    }
    public List<Double> visit(ev.ep.m4.Lit exp) {
        return java.util.Arrays.asList(exp.getValue());
    }
    public List<Double> visit(ev.ep.m0.Lit exp) {
        return java.util.Arrays.asList(exp.getValue());
    }

    public List<Double> visit(ev.ep.m7i2.Add exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.m4.Add exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }
    public List<Double> visit(ev.ep.m0.Add exp) {
        return java.util.stream.Stream.concat(exp.getLeft().accept(this.makeCollect()).stream(), exp.getRight().accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }
    public CollectPower makeCollect() {
        return new CollectPower();
    }

}
