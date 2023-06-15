import play.api.libs.json._

case class Child(name: String, age: Int)      // V1 model
case class Parent(foo: Int, bar: Int, child: Child)

object Main {
  implicit val childFormat = Json.format[Child]
  implicit val parentFormat = Json.format[Parent]

  def main(args: Array[String]): Unit = {
    val obj =
      Parent(
        foo = 42,
        bar = 61,
        child = Child("Harris Longfellow Lewis Lucas", 3)
      )

    println(Json.toJson(obj).toString)
  }
}
