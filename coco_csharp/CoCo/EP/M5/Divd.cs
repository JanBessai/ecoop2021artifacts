using System.Collections.Generic;

namespace EP.M5 {
    public interface Divd<FT> : Exp<FT>, EP.M4.Divd<FT> {

        Tree Exp<FT>.astree() {
            return new Node(convert(this).id(), convert(getLeft()).astree(), convert(getRight()).astree());
        }

        int Exp<FT>.id() {
            return 2130451;
        }
    }
}