using System.Collections.Generic;

namespace EP.M5 {
    public interface Neg<FT> : Exp<FT>, EP.M4.Neg<FT> {

        Tree Exp<FT>.astree() {
            return new Node(convert(this).id(), convert(getInner()).astree());
        }

        int Exp<FT>.id() {
            return 78192;
        }
    }
}