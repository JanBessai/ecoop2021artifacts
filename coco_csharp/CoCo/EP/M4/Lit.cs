using System.Collections.Generic;

namespace EP.M4 {
    public interface Lit<FT> : Exp<FT>, EP.M2.Lit<FT> {

        void Exp<FT>.truncate (int level) { }
	
        EP.Exp<FT> Exp<FT>.simplify() { return this; }

        List<double> Exp<FT>.collect() {
            List<double> result = new List<double>();
            result.Add(getValue());
            return result;
        }
    }
}