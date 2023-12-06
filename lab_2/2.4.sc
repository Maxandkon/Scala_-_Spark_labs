package LR

class Instructor(val id: Int, val name: String, val surname: String) {
  def fullName(): String = {
    val formattedName = name.head.toUpper + name.tail.toLowerCase
    val formattedSurname = surname.head.toUpper + surname.tail.toLowerCase
    s"$formattedName $formattedSurname"
  }
}


class Course(val courseId: Int, val title: String, val releaseYear: String, val instructor: Instructor) {

  def getID(): String = s"$courseId${instructor.id}"
  def isTaughtBy(otherInstructor: Instructor): Boolean = instructor == otherInstructor
  def copyCourse(newReleaseYear: String): Course = new Course(courseId, title, newReleaseYear, instructor)
  def print(): Unit = {
    println(s"$courseId $title $releaseYear ${instructor.id} ${instructor.fullName()}")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val instr1 = new Instructor(1, "nNNnn", "aaAAAaa")
    val instr2 = new Instructor(2, "nNNnn", "aaAAAaa")
    val ob1 = new Course(50, "111", "1990", instr1)
    val ob2 = new Course(50, "111", "1990", instr1)

    println(instr1.fullName())
    println(ob1.getID())

    if (ob2.isTaughtBy(instr2)) println("Yes")
    else println("No")

    if (ob2.isTaughtBy(instr1)) println("Yes")
    else println("No")
	
    ob1.print()
    val ob3 = ob1.copyCourse("2000")
    ob3.print()
  }
}

