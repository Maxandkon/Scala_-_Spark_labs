package LR

object TailRecursionExample {

  def tailRecursion(x: Int, y: Int, n: Int): Int = {
    if (n == 0) x
    else {
      println(x)
      tailRecursion(x + y, y, n - 1) 
    }
  }

  def countDigits(number: Int): Int = {
  
    if (number < 10) 1
    else {
      1 + countDigits(number / 10)
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
  
    val input = readLine().split(" ").map(_.toInt)
    val x = input(0)
    val y = input(1)
    val n = input(2)

    val result = TailRecursionExample.tailRecursion(x, y, n)

    val digits = TailRecursionExample.countDigits(result)

    for (_ <- 1 to digits) {
      print(result + " ")
    }
    println("is the result")
  }
}

