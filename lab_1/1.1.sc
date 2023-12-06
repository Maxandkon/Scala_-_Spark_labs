package LR

object Main {
  def aCondition(): Boolean = if (1 > 2) true else false

  def multiply(x: Int): Int = {
    var result = x
    while (true) { 
      result *= 2
    }
    result
  }

  def someFunc(x: Int, y: Int): Int = {
    if (aCondition()) x * 2
    else multiply(y)
  }

  def main(args: Array[String]): Unit = {
    val result = someFunc(3, multiply(4))
    println(result)
  }
}


