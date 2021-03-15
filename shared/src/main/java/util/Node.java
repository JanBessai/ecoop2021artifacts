package util;

import java.util.List;

public final class Node implements util.Tree {

    public final int label;

    public final List<Tree> subtrees;

    @Override
    public int hashCode() {
        return java.util.Objects.hash(label, subtrees);
    }

    @Override
    public boolean equals(Object other) {
        return defaultEquals(other);
    }

    public Node(int label, util.Tree... children) {
        this.label = label;
        this.subtrees = java.util.Arrays.asList(children);
    }

    @Override
    public java.util.Optional<Node> asNode() {
        return java.util.Optional.of(this);
    }

    @Override
    public String toString() {
        return "Node{" + "label=" + label + ", subtrees=" + subtrees.stream().map(Tree::toString).collect(java.util.stream.Collectors.joining(",", "[", "]")) + '}';
    }
}
