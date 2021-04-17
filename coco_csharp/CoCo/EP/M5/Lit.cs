using System.Collections.Generic;

namespace EP.M5 {
    public interface Lit<FT> : Exp<FT>, EP.M4.Lit<FT> {

        Tree Exp<FT>.astree() {
            return new Node(convert(this).id(), new Leaf(getValue()));
        }

        int Exp<FT>.id() {
            return 76407;
        }
    }
}