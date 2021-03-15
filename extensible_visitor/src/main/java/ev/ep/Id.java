package ev.ep;

public class Id implements VisitorDivdMultNeg<Integer> {

    public Id() {
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

    public ev.ep.Id makeId() {
        return new ev.ep.Id();
    }
}
