using System.Collections.Generic;

namespace EP.M5 {
    public interface Mult<FT> : Exp<FT>, EP.M4.Mult<FT> {

        Tree Exp<FT>.astree() {
            return new Node(convert(this).id(), convert(getLeft()).astree(), convert(getRight()).astree());
        }

        int Exp<FT>.id() {
            return 2409808;
        }
    }
}