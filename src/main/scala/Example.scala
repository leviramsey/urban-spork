import play.api.libs.json._

case class Child(name: String, age: Int, height: Option[Int])      // V2 model
case class Parent(foo: Int, bar: Int, child: Child)

object Main {
  implicit val childFormat = Json.format[Child]
  implicit val parentFormat = Json.format[Parent]

  val jsonFromV1 = """{"foo":42,"bar":61,"child":{"name":"Harris Longfellow Lewis Lucas","age":3}}"""

  def main(args: Array[String]): Unit = {
    val parent = Json.parse(jsonFromV1).as[Parent]

    println(s"parent foo = ${parent.foo}")
    println(s"parent bar = ${parent.bar}")
    println(s"child name = ${parent.child.name}")
    println(s"child age = ${parent.child.age}")
    println(s"child height = ${parent.child.height}")
  }
}
