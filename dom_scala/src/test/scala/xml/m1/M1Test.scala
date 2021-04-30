package xml.m1

import xml.m0._

trait M1TestTemplate[T <: Types] extends xml.m0.M0TestTemplate[T] {
  override val factory: SFactory[T]

  test("M1") {
    import factory._
    val doc = singleRoot(factory.tag("top"))
    val doc2 = singleRoot(factory.tag("top2"))
    val testSchema = schema(doc)
    val testSchema2 = schema(doc2)
    assert(testSchema.hasElem("top"))
    assert(!doc.sameRootElements(doc2))
    assert(doc.sameRootElements(doc))
    assert(testSchema.deepClone.hasElem("top"))
    assert(!testSchema.deepClone.hasElem("top2"))
    assert(testSchema2.deepClone.hasElem("top2"))
    assert(!testSchema2.deepClone.hasElem("top"))
    assert(!testSchema.addChild(factory.tag("foo")))
    assert(!testSchema.addChild(factory.text("foo")))
    assert(convert(testSchema).eq(testSchema))
  }
}

class M1Test extends M1TestTemplate[finalized.FTypes] {
  val factory: SFactory[xml.m0.finalized.FTypes] = new xml.m1.finalized.FSFactory {}
  val emptyDoc = new EmptyDoc with xml.m1.finalized.FSFactory with finalized.FDocument
}