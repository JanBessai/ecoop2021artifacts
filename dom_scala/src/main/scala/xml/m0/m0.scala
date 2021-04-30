package xml.m0

trait Types {
  type FX
  type FT
  type FD
}

trait Factory[T <: Types] {
  val types: T

  def text(name: String): XML[T]
  def tag(name: String, children: XML[T]*): Tag[T]
  def singleRoot(tag: Tag[T]): Document[T]

  implicit def convert(other: XML[T]): XML[T]
  implicit def convert(other: Tag[T]): Tag[T]
  implicit def convert(other: Document[T]): Document[T]
}


trait XML[T <: Types] extends Factory[T] {
  def getSelfXML: types.FX

  def notHasElem(text: String): Boolean = !hasElem(text)
  def hasElem(text: String): Boolean
  def addChild(child: XML[T]): Boolean
  def deepClone: XML[T]
}

trait Text[T <: Types] extends XML[T] {
  def text: String

  override def hasElem(text: String): Boolean = this.text == text
  override def addChild(child: XML[T]) = false
  override def deepClone: XML[T] = this.text(text)
}

trait Tag[T <: Types] extends XML[T] {
  def getSelfTag: types.FT

  def name: String
  var _children: Seq[XML[T]]
  def children: Seq[XML[T]] = _children

  override def deepClone: Tag[T] = {
    this.tag(name, children.map(_.deepClone): _*)
  }

  override def hasElem(text: String): Boolean = {
    if (text == name) true
    else children.exists(_.hasElem(text))
  }

  override def addChild(child: XML[T]): Boolean = {
    this._children = children :+ child
    true
  }
}

trait Document[T <: Types] extends XML[T] {
  def getSelfDocument: types.FD

  def sameRootElements(doc: Document[T]): Boolean
  override def deepClone: Document[T]
  def rootTag: Option[Tag[T]]
}

trait SingleRoot[T <: Types] extends Document[T] {
  def root: Tag[T]

  override def rootTag: Option[Tag[T]] = Some(root)
  override def hasElem(text: String): Boolean = root.hasElem(text)
  override def addChild(child: XML[T]) = false
  override def deepClone: Document[T] = this.singleRoot(root.deepClone)

  override def sameRootElements(other: Document[T]): Boolean = {
    other.rootTag.exists(_.name == root.name)
  }
}

object finalized {
  class FTypes extends Types {
    type FX = FXML
    type FT = FTag
    type FD = FDocument
  }
  val fTypes: FTypes = new FTypes

  trait FFactory extends Factory[FTypes] {
    val types: FTypes = fTypes
    def text(name: String): XML[FTypes] = new FText(name)
    def tag(name: String, children: XML[FTypes]*): Tag[FTypes] = new FTag(name, children)
    def singleRoot(tag: Tag[FTypes]): Document[FTypes] = new FSingleRoot(tag)

    implicit def convert(other: XML[FTypes]): XML[FTypes] = other.getSelfXML
    implicit def convert(other: Tag[FTypes]): Tag[FTypes] = other.getSelfTag
    implicit def convert(other: Document[FTypes]): Document[FTypes] = other.getSelfDocument
  }
  trait FXML extends XML[FTypes] with FFactory { def getSelfXML: FXML = this }
  class FText(val text: String) extends Text[FTypes] with FXML
  class FTag(val name: String, var _children: Seq[XML[FTypes]]) extends Tag[FTypes] with FXML {
    def getSelfTag: FTag = this
  }
  trait FDocument extends Document[FTypes] with FXML { def getSelfDocument: FDocument = this }
  class FSingleRoot(val root: Tag[finalized.FTypes]) extends SingleRoot[FTypes] with FDocument
}