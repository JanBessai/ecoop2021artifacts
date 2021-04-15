package exp.m5


abstract class Tree {

  def asLeaf: Option[Leaf] = None

  def asNode: Option[Node] = None

  def toString:String

  /** link in with default equals. */
  override def equals(tree: Any) : Boolean = {
    tree match {
      case o: Tree => same(o)
      case _ => false
    }
  }

  def same(o : Tree) : Boolean = {
    val leafCheck:Option[Boolean] = asLeaf.flatMap(leaf => o.asLeaf.map(leaf2 => leaf.value == leaf2.value))
    val nodeCheck:Option[Boolean] = asNode.flatMap(node => o.asNode.map(node2 => {
      // must be same label
      if (!(node2.label == node.label)) {
        return false
      }

      // short-circuit if not same length
      if (node2.subtrees.length != node.subtrees.length) {
        return false
      }

      for ((a, b) <- node.subtrees zip node2.subtrees) {
        if (!a.same(b)) {
          return false
        }
      }

      return true
    }))

    // only two possibilities, else false
    leafCheck.getOrElse(nodeCheck.getOrElse(false))
  }

}

class Leaf(val value : Any) extends Tree {
  override def asLeaf : Option[Leaf] = Some(this)

  override def toString : String =  String.format("[%s]", value.toString)
}

class Node(val label:Int, val children:Tree*) extends Tree {
  // copy elements
  val subtrees : Seq[Tree] = children.map {x => x}

  override def asNode : Option[Node] = Some(this)

  override def toString : String =  {
    val combined:String = children.map(x => x.toString).mkString(" ")
    String.format("(%d  %s)", label, combined)
  }
}
