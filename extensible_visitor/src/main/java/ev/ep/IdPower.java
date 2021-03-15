package ev.ep;

public class IdPower implements VisitorPower<Integer> {

    public IdPower() {
    }

    public Integer visit(Power exp) {
        return 77306085;
    }

    public Integer visit(Neg exp) {
        return 78192;
    }

    public Integer visit(Mult exp) {
        return 2409808;
    }

    public Integer visit(Divd exp) {
        return 2130451;
    }

    public Integer visit(Sub exp) {
        return 83488;
    }

    public Integer visit(Lit exp) {
        return 76407;
    }

    public Integer visit(Add exp) {
        return 65665;
    }

    public ev.ep.IdPower makeId() {
        return new ev.ep.IdPower();
    }
}
