using System.Collections.Generic;

namespace EP.M5 {
    public interface Add<FT> : Exp<FT>, EP.M4.Add<FT> {

        Tree Exp<FT>.astree() {
            return new Node(convert(this).id(), convert(getLeft()).astree(), convert(getRight()).astree());
        }

        int Exp<FT>.id() {
            return 65665;
        }
    }
}