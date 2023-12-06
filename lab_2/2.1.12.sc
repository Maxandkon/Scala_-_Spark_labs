package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("SparkOperationsExample").setMaster("local")

      val sc = new SparkContext(conf)

      // Приклад 1: Для List(List("qw wq"), List("12")) отримати List(qw wq, 12)
      val input1 = sc.parallelize(List(List("qw wq"), List("12")))
      val result1 = input1.flatMap(_.toList)

      println("Приклад 1:")
      println("result -> " + result1.collect.mkString(","))

      // Приклад 2: Для List(List(1, 2), List(5, 6)) отримати List(2, 4, 10, 12)
      val input2 = sc.parallelize(List(List(1, 2), List(5, 6)))
      val result2 = input2.flatMap(_.map(_ * 2))

      println("Приклад 2:")
      println("result -> " + result2.collect.mkString(","))

      // Приклад 3: Для List(List(1, 2, 3), List(4, 5)) отримати List(2, 4, 6, 8, 10)
      val input3 = sc.parallelize(List(List(1, 2, 3), List(4, 5)))
      val result3 = input3.flatMap(_.map(_ * 2))

      println("Приклад 3:")
      println("result -> " + result3.collect.mkString(","))

      // Приклад 4: Для List(List("ab cd ef"), List("12 34 56")) отримати List(a, b, " ", c, d, " ", e, f, 1, 2, " ", 3, 4, " ", 5, 6)
      val input4 = sc.parallelize(List(List("ab cd ef"), List("12 34 56")))
      val result4 = input4.flatMap(_.flatMap(_.split(" ")))

      println("Приклад 4:")
      println("result -> " + result4.collect.mkString(","))

      // Завершуємо SparkContext
      sc.stop()
    }
  }




