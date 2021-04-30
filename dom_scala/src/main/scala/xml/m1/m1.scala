package xml.m1

import xml.m0._

trait SFactory[T <: Types] extends Factory[T] {
  def schema(document: Document[T]): XML[T]
}

trait Schema[T <: Types] extends SFactory[T] with XML[T] {
  def document: Document[T]

  override def hasElem(text: String): Boolean = document.hasElem(text)
  override def addChild(child: XML[T]) = false
  override def deepClone: XML[T] = this.schema(document.deepClone)
}

object finalized {
  import xml.m0.finalized._
  trait FSFactory extends FFactory with SFactory[FTypes] {
    def schema(document: Document[FTypes]): XML[FTypes] = new FSchema(document)
  }
  class FSchema(val document: Document[FTypes]) extends Schema[FTypes] with FXML with FSFactory
}