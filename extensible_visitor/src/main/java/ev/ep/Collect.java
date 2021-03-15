package ev.ep;

import java.util.List;

public class Collect implements VisitorDivdMultNeg<List<Double>> {

    public Collect() {
    }

    public List<Double> visit(Neg exp) {
        return exp.getInner().<List<Double>>accept(this.makeCollect());
    }

    public List<Double> visit(Mult exp) {
        return java.util.stream.Stream.concat(exp.getLeft().<List<Double>>accept(this.makeCollect()).stream(), exp.getRight().<List<Double>>accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public List<Double> visit(Divd exp) {
        return java.util.stream.Stream.concat(exp.getLeft().<List<Double>>accept(this.makeCollect()).stream(), exp.getRight().<List<Double>>accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public List<Double> visit(Sub exp) {
        return java.util.stream.Stream.concat(exp.getLeft().<List<Double>>accept(this.makeCollect()).stream(), exp.getRight().<List<Double>>accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public List<Double> visit(Lit exp) {
        return java.util.Arrays.asList(exp.getValue());
    }

    public List<Double> visit(Add exp) {
        return java.util.stream.Stream.concat(exp.getLeft().<List<Double>>accept(this.makeCollect()).stream(), exp.getRight().<List<Double>>accept(this.makeCollect()).stream()).collect(java.util.stream.Collectors.toList());
    }

    public ev.ep.Collect makeCollect() {
        return new ev.ep.Collect();
    }
}
