package interpreter.ep.m6;

import interpreter.ep.m5.AstreeIdzExp;

public interface EqualsExp extends AstreeIdzExp {

    Boolean equals(EqualsExp that);
    
    Boolean eql(EqualsExp that);
    
    default Boolean isLit(Double d) { return false; }
    default Boolean isAdd(EqualsExp left, EqualsExp right) { return false; }
    default Boolean isSub(EqualsExp left, EqualsExp right) { return false; }
    default Boolean isMult(EqualsExp left, EqualsExp right) { return false; }
    default Boolean isNeg(EqualsExp inner) { return false; }
    default Boolean isDivd(EqualsExp left, EqualsExp right) { return false; }

    // producer methods must be present in all subsequent evolutions
    EqualsExp simplify();

    // all subsequent data types involved in Truncate must also duplicate logic to access correct lit() factory method
}
