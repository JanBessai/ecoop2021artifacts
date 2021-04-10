package ev.ep.m6;

public interface EqlQuery {

    default Boolean isLit(Double d) { return false; }
    default Boolean isAdd(EqlQuery left, EqlQuery right) { return false; }
    default Boolean isSub(EqlQuery left, EqlQuery right) { return false; }
    default Boolean isMult(EqlQuery left, EqlQuery right) { return false; }
    default Boolean isNeg(EqlQuery inner) { return false; }
    default Boolean isDivd(EqlQuery left, EqlQuery right) { return false; }
}
