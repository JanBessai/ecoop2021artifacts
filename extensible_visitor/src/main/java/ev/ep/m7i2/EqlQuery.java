package ev.ep.m7i2;

import ev.ep.Visitor;

public interface EqlQuery extends ev.ep.m6.EqlQuery {
    default Boolean isPower(EqlQuery left, EqlQuery right) {
        return false;
    }

    <R> R accept(Visitor<R> v);
}