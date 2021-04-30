package xml.m0

import org.scalatest.FunSuite

trait M0TestTemplate[T <: Types] extends FunSuite {
  val factory: Factory[T]
  val emptyDoc: Document[T]

  trait EmptyDoc extends Document[T] with Factory[T] {
    override def rootTag: Option[Tag[T]] = Option.empty
    def sameRootElements(doc: Document[T]): Boolean = doc.rootTag.isEmpty
    override def deepClone: Document[T] = emptyDoc
    def hasElem(text: String): Boolean = false
    def addChild(child: XML[T]): Boolean = false
  }

  test("M0") {
    import factory._
    val testTag = tag("html")
    assert(testTag.addChild(tag("head")))
    assert(testTag.addChild(tag("body")))
    assert(convert(testTag).eq(testTag))

    assert(testTag.hasElem("body"))
    assert(testTag.notHasElem("script"))
    assert(testTag.deepClone.hasElem("head"))
    assert(testTag.deepClone.hasElem("body"))
    assert(testTag.deepClone.notHasElem("script"))

    val testText = text("test")
    assert(testText.hasElem("test"))
    assert(testText.notHasElem("html"))
    assert(!testText.addChild(testTag))
    assert(!testText.addChild(testText))
    testText.deepClone.hasElem("test")
    testText.deepClone.notHasElem("Test")
    assert(convert(testText).eq(testText))

    val testSingleRoot = singleRoot(testTag)
    assert(testSingleRoot.rootTag.nonEmpty)
    assert(testSingleRoot.rootTag.get == testTag)
    assert(testSingleRoot.hasElem("body"))
    assert(testSingleRoot.notHasElem("script"))
    assert(testSingleRoot.deepClone.hasElem("head"))
    assert(testSingleRoot.deepClone.hasElem("body"))
    assert(testSingleRoot.deepClone.notHasElem("script"))
    assert(testSingleRoot.sameRootElements(testSingleRoot.deepClone))
    assert(!testSingleRoot.addChild(testText))
    assert(!testSingleRoot.addChild(testTag.deepClone))
    assert(!testSingleRoot.sameRootElements(singleRoot(tag("head"))))
    assert(!testSingleRoot.sameRootElements(emptyDoc))
    assert(convert(testSingleRoot).eq(testSingleRoot))
  }
}

class M0Test extends M0TestTemplate[finalized.FTypes] {
  val factory: Factory[finalized.FTypes] = new finalized.FFactory {}
  val emptyDoc = new EmptyDoc with finalized.FFactory with finalized.FDocument
}
