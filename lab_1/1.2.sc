package LR
import scala.annotation.tailrec

object Main {

  // Функция powerOfTwo принимает целое число n и возвращает 2 в степени n.
  def powerOfTwo(n: Int): BigInt = {
    @tailrec
    // Внутренняя функция powerOfTwoHelper - это хвостовая рекурсивная функция,
    // которая выполняет вычисления и аккумулирует результат.
    def powerOfTwoHelper(n: Int, acc: BigInt): BigInt = {
      // Если n достигло 0, возвращаем аккумулированное значение (результат).
      if (n == 0) {
        acc
      } else {
        // В противном случае рекурсивно вызываем powerOfTwoHelper
        // с уменьшенным n и умноженным на 2 аккумулятором.
        powerOfTwoHelper(n - 1, acc * 2)
      }
    }

    // Проверяем, что значение n не отрицательное.
    if (n < 0) {
      // Если n отрицательное, выбрасываем исключение с сообщением об ошибке.
      throw new IllegalArgumentException("Негативні ступені не підтримуються")
    } else {
      // В противном случае вызываем powerOfTwoHelper с начальными значениями n и аккумулятора (acc = 1).
      powerOfTwoHelper(n, 1)
    }
  }

  def main(args: Array[String]): Unit = {
    // Вызываем функцию powerOfTwo с аргументом 2. если 
    val result = powerOfTwo(2)
    // Выводим результат на экран, который должен быть равен 4 (2^ powerOfTwo(n)).
    println(result) // Виведе 4
  }
}

