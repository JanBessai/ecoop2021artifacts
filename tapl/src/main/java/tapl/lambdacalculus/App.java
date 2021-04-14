package tapl.lambdacalculus;

public interface App<Elem, Tm> extends Term<Elem, Tm>, tapl.varapp.App<Elem, Tm> {
    @Override default tapl.Term<Elem, Tm> eval() {
        Term<Elem, Tm> simplified = convert(tapl.varapp.App.super.eval());
        if (simplified != this) {
            return simplified;
        }
        return convert(getLeft())
                .matchAbstraction()
                .filter(abs -> getRight().isValue())
                .map(abs -> abs.termSubstTop(getRight()))
                .orElse(this);
    }
}
