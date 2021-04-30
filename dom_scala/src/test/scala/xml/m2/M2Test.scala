package xml.m2

import xml.m0._
import xml.m1._

trait M2TestTemplate[T <: ETypes] extends M1TestTemplate[T] {
  override val factory: EFactory[T]

  test("M2") {
    import factory._
    val doc = singleRoot(tag("top", tag("a"), tag("b")))

    val doc2 = singleRoot(tag("top", tag("a"), text("ttt"), tag("b")))
    val doc3 = singleRoot(tag("top", tag("b")))
    val doc4 = singleRoot(tag("top", tag("b"), text("ttt")))
    val doc5 = singleRoot(tag("top", tag("a")))
    val doc6 = singleRoot(tag("top", tag("a"), tag("b"), text("ttt"), tag("c")))

    val testSchema = schema(doc)

    assert(testSchema.validate(doc2.rootTag.get).isEmpty)
    assert(testSchema.validate(doc3.rootTag.get).isDefined)
    assert(testSchema.validate(doc4.rootTag.get).isDefined)
    assert(testSchema.validate(doc5.rootTag.get).isDefined)
    assert(testSchema.validate(doc6.rootTag.get).isEmpty)

    assert(schema(doc2).validate(doc2.rootTag.get).isDefined)

    assert(tag("noSchema").validate(doc.rootTag.get).isDefined)
  }
}

class M2Test extends M2TestTemplate[xml.m2.finalized.FETypes] {
  val factory: EFactory[xml.m2.finalized.FETypes] = new xml.m2.finalized.FEFactory {}
  val emptyDoc = new EmptyDoc with xml.m2.finalized.FEDocument
}
