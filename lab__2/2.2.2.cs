package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("SparkAirlineData").setMaster("local[*]")
      val sc = new SparkContext(conf)

      // Вихідні дані в формі RDD
      val data = sc.parallelize(List(
        (8, 20, 18, 9, 7, 6),
        (15, 23, 12, 11, 5, 4),
        (10, 15, 5, 6, 11, 3),
        (7, 14, 8, 12, 15, 2),
        (6, 18, 9, 15, 9, 1)
      ))

      // 1) Заповнюємо набір даних по авіакомпаніях
      val airlineData = data.collect()

      // 2) Визначення числа рейсів, разом зі всіма авіакомпаніями
      val sumOfFlights = data.flatMap(row => row.productIterator.map(_.asInstanceOf[Int])).sum()

      // 3) Визначимо максимальну кількість рейсів в кожній авіакомпанії і суму цих максимальних кількостей
      val maxFlightsPerAirline = data.map(row => row.productIterator.map(_.asInstanceOf[Int]).max)
      val sumOfMaximums = maxFlightsPerAirline.sum()

      // 4) Визначимо максимальну кількість рейсів, що припадає на одну авіакомпанію
      val maximum = maxFlightsPerAirline.max()

      // 5) Визначаємо, скільки в середньому рейсів виконує одна авіакомпанія в одному аеропорту
      val flightsAndAirlines = (sumOfFlights, data.count().toInt)
      val avg = sumOfFlights.toDouble / data.count() / data.first().productArity

      // Виведемо результати
      println("Завдання 1:")
      airlineData.foreach(println)
      println("Завдання 2: " + sumOfFlights)
      println("Завдання 3: " + sumOfMaximums)
      println("Завдання 4: " + maximum)
      println("Завдання 5: " + flightsAndAirlines + " Avg: " + avg)

      sc.stop()
    }
  }




