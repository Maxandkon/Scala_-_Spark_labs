package LR
import scala.annotation.tailrec

object Main {

  def powerOfTwo(n: Int): BigInt = {
    @tailrec
    def powerOfTwoHelper(n: Int, acc: BigInt): BigInt = {
      if (n == 0) {
        acc
      } else {
        powerOfTwoHelper(n - 1, acc * 2)
      }
    }

    if (n < 0) {
      throw new IllegalArgumentException("No negative power | Без негативних ступенів")
    } else {
      powerOfTwoHelper(n, 1)
    }
  }

  def main(args: Array[String]): Unit = {
    val result = powerOfTwo(2)
    println(result)
  }
}

