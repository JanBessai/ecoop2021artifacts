using System;
using System.Collections.Generic;

namespace EP.M5 {
    public interface Tree {
        // C# doesn't support option, so we use a 1-element List.
        public List<Leaf> asLeaf() {
            return new List<Leaf>();
        }

        public List<Node> asNode() {
            return new List<Node>();
        }

        public bool Equals(object other) {
            if (other == null) {
                return false;
            } else if (other is Leaf) {
                return ((Leaf)other).Equals(this);
            } else if (other is Node) {
                return ((Node)other).Equals(this);
            }
            return false;
        }
    }

    public class Leaf : Tree {

        public object value;

        
        override public int GetHashCode() {
            return value.GetHashCode();
        }

        override public bool Equals(object obj) {
            if (this == obj) {
                return true;    
            } 
            else if ((obj == null) || !(obj is Leaf))
            {
                return false;
            }
            else {
                Leaf otherTree = (Leaf) obj;
                return value.Equals(otherTree.value);
            }
        }

        override public string ToString() {
            return "Leaf{" + "value=" + value + '}';
        }

        public Leaf(object e) {
            value = e;
        }

        List<Leaf> Tree.asLeaf() {
            return new List<Leaf>() { this };
        }
    }

    public class Node : Tree {
        public int label;

        public List<Tree> subtrees;

        override public int GetHashCode() {
            return Tuple.Create(label, subtrees).GetHashCode();
        }

        override public bool Equals(object other) {
            if (other == this) {
                return true;
            } else if (other == null) {
                return false;
            } else if (other is Node) {
                Node otherNode = (Node)other;
                if (label != otherNode.label) return false;
                if (subtrees.Count != otherNode.subtrees.Count) return false;
                for (int i = 0; i < subtrees.Count; i++) {
                    if (!subtrees[i].Equals(otherNode.subtrees[i])) return false;
                }

                return true;
            } else {
                return false;
            }
        }

        public Node(int _label, params Tree[] _children) {
            label = _label;
            subtrees = new List<Tree>();
            subtrees.AddRange(_children);
        }

        List<Node> Tree.asNode() {
            return new List<Node>() { this };
        }
        
        override public string ToString() {
            return "Node{" + "label=" + label + ", subtrees=[" + string.Join(", ", subtrees) + "]}";
        }
    }

}