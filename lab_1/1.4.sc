package LR

object Main {
  def main(args: Array[String]): Unit = {
    println("Print line | Введіть рядок : ")

    val input = scala.io.StdIn.readLine()

    val words = input.split(" ").filterNot(_.isEmpty)

    val reversedString = words.reverse.mkString(" ")

    println(s"Результат: $reversedString")
  }
}






