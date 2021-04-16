package tapl.bool.f;

public class IfThenElse implements Term, tapl.bool.IfThenElse<Element, Term> {
    tapl.Term<Element, Term> cond;
    tapl.Term<Element, Term> ifBranch;
    tapl.Term<Element, Term> elseBranch;

    public IfThenElse(tapl.Term<Element, Term> cond, tapl.Term<Element, Term> ifBranch, tapl.Term<Element, Term> elseBranch) {
        this.cond = cond;
        this.ifBranch = ifBranch;
        this.elseBranch = elseBranch;
    }

    @Override public tapl.Term<Element, Term> getCondition() { return cond; }

    @Override public tapl.Term<Element, Term> getIfBranch() { return ifBranch; }

    @Override public tapl.Term<Element, Term> getElseBranch() { return elseBranch; }
}
