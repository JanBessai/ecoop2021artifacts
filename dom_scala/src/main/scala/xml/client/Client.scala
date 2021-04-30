package xml.client
import xml.m0._
import xml.m2._
import xml.m2.finalized._

trait ClientM0[T <: Types] {
  val factory: Factory[T]
  import factory._
  val demoDoc = singleRoot(tag("designPattern", tag("name", text("CoCo")), tag("relatedPattern", text("Factory"))))

  def run(): Unit = {
    System.out.println("Has CoCo: " + demoDoc.hasElem("CoCo"))
    System.out.println("Has relatedPattern: " + demoDoc.hasElem("relatedPattern"))
    System.out.println("Has Visitor: " + demoDoc.hasElem("Visitor"))
    System.out.println("Has related: " + demoDoc.hasElem("related"))
  }
}

trait ClientM2[T <: ETypes] {
  val factory: EFactory[T]
  val collaborator: ClientM0[T]
  import factory._
  val schema = factory.schema(singleRoot(tag("designPattern", tag("name"), tag("relatedPattern"))))

  def run(): Unit = {
    collaborator.run()
    val root = collaborator.demoDoc.rootTag
    if (root.isEmpty) return
    val isValid = schema.validate(root.get)
    System.out.println("Errors: " + isValid)
  }
}

object Client extends App {
  lazy val _factory: FEFactory = new FEFactory {}
  lazy val client: ClientM0[FETypes] = new ClientM0[FETypes] { lazy val factory = _factory }
  lazy val evolved: ClientM2[FETypes] = new ClientM2[FETypes] { lazy val factory = _factory; lazy val collaborator = client }
  evolved.run()
}
