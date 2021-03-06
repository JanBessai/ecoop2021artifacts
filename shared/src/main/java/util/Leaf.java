package util;

public final class Leaf<T> implements Tree {

    public final T value;

    @Override
    public int hashCode() {
        return java.util.Objects.hash(value);
    }

    @Override
    public boolean equals(Object other) {
        return defaultEquals(other);
    }

    @Override
    public String toString() {
        return "Leaf{" + "value=" + value + '}';
    }

    public Leaf(T e) {
        value = e;
    }

    @Override
    public java.util.Optional<Leaf<?>> asLeaf() {
        return java.util.Optional.of(this);
    }
}
