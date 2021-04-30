package xml.m2

import xml.m0._
import xml.m1._

trait ETypes extends Types

trait EFactory[T <: ETypes] extends SFactory[T] {
  override implicit def convert(other: XML[T]): EXML[T]
  override implicit def convert(other: Tag[T]): ETag[T]
  override implicit def convert(other: Document[T]): EDocument[T]
}

trait EXML[T <: ETypes] extends XML[T] with EFactory[T] {
  def asTag: Option[Tag[T]] = Option.empty
  def validate(toValidate: Tag[T]): Option[String] = Some("Invalid validation request.")
}

trait EText[T <: ETypes] extends Text[T] with EXML[T]

trait ETag[T <: ETypes] extends Tag[T] with EXML[T] {
  override def asTag: Option[Tag[T]] = Some(this)
}

trait EDocument[T <: ETypes] extends Document[T] with EXML[T]
trait ESingleRoot[T <: ETypes] extends SingleRoot[T] with EDocument[T]

trait ESchema[T <: ETypes] extends Schema[T] with EXML[T] {
  override def validate(toValidate: Tag[T]): Option[String] = {
    val doc = this.singleRoot(toValidate)
    if (!document.sameRootElements(doc)) return Some("Root element mismatch!")
    val childrenToValidate = toValidate.children
    var idx = 0
    for (child <- document.rootTag.get.children) {
      val tag = child.asTag
      if (tag.isEmpty) return Some("Schema can only include tags")
      else {
        var tagToValidate: Option[Tag[T]] = Option.empty
        while ( {
          tagToValidate.isEmpty && idx < childrenToValidate.length
        }) {
          tagToValidate = convert(childrenToValidate(idx)).asTag
          idx += 1
        }
        if (tagToValidate.isEmpty) return Some("Missing tag:" + tag.get.name)
        val matcher = this.schema(this.singleRoot(tag.get))
        val result = matcher.validate(tagToValidate.get)
        if (result.nonEmpty) return result // the error which was found
      }
    }
    Option.empty
  }
}

object finalized {
  class FETypes extends ETypes {
    type FX = FEXML
    type FT = FETag
    type FD = FEDocument
  }
  val efTypes: FETypes = new FETypes

  trait FEFactory extends EFactory[FETypes] {
    val types: FETypes = efTypes
    def text(name: String): XML[FETypes] = new FEText(name)
    def tag(name: String, children: XML[FETypes]*): Tag[FETypes] = new FETag(name, children)
    def singleRoot(tag: Tag[FETypes]): Document[FETypes] = new FESingleRoot(tag)
    def schema(document: Document[FETypes]): XML[FETypes] = new FESchema(document)

    implicit def convert(other: XML[FETypes]): EXML[FETypes] = other.getSelfXML
    implicit def convert(other: Tag[FETypes]): ETag[FETypes] = other.getSelfTag
    implicit def convert(other: Document[FETypes]): EDocument[FETypes] = other.getSelfDocument
  }
  trait FEXML extends EXML[FETypes] with FEFactory { def getSelfXML: FEXML = this }
  class FEText(val text: String) extends EText[FETypes] with FEXML
  class FETag(val name: String, var _children: Seq[XML[FETypes]]) extends ETag[FETypes] with FEXML {
    def getSelfTag: FETag = this
  }
  trait FEDocument extends EDocument[FETypes] with FEXML { def getSelfDocument: FEDocument = this }
  class FESingleRoot(val root: Tag[finalized.FETypes]) extends ESingleRoot[FETypes] with FEDocument
  class FESchema(val document: Document[FETypes]) extends ESchema[FETypes] with FEXML with FEFactory
}

