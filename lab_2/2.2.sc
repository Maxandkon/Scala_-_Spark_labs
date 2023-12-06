package LR


class Person(fullName: String) {
  private val parts = fullName.split(" ")

  def firstName: String = parts.head
  def lastName: String = parts.last
}


object Main {
  def main(args: Array[String]): Unit = {
    val person = new Person("Fred Smith")

    val firstName = person.firstName
    val lastName = person.lastName

    println(s"First Name: $firstName")
    println(s"Last Name: $lastName")
  }
}
