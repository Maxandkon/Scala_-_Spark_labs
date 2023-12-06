package LR

object Main {
  def aCondition(): Boolean = if (1 > 2) true else false //Прикол функции в том, что он всегда дает false чтобы код нормально заработал, то ему надо поменять местами цифры

  def multiply(x: Int): Int = {
    var result = x
    while (true) { // Естетсвенно будет работать бесконечно так как у нас БУКВАЛЬНО БЕСКОНЕЧНЫЙ ЦИКЛ, надо менять количество итераций
      result *= 2
    }
    result
  }

  def someFunc(x: Int, y: Int): Int = {
    if (aCondition()) x * 2 //Проверка условия, если true то просто множим на два первое число, если нет, то переходим к "бесконечному умножению на 2 второго числа"
    else multiply(y)
  }

  def main(args: Array[String]): Unit = {
    // Вызов функции должен быть следующим
    val result = someFunc(3, multiply(4))
    println(result) // должно вывести 6 если условие будет true а не false, если нет, то будет работать бесконечно, пока не поставим конкретное количетсво итераций в функции multiply
  }
}


