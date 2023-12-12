package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("SparkWeekdayGrouping").setMaster("local[*]")
      val sc = new SparkContext(conf)

      // Створимо RDD з днями тижня
      val weekdays = sc.parallelize(List(
        (7, "Tuesday"),
        (8, "Thursday"),
        (8, "Saturday"),
        (9, "Wednesday"),
        (6, "Sunday"),
        (6, "Monday"),
        (6, "Friday")
      ))

      // Виконаємо groupByKey для групування за ключами
      val groupedWeekdays = weekdays.groupByKey()

      // Виведемо результат
      val result = groupedWeekdays.collect()
      result.foreach { case (key, values) =>
        println(s"($key, ${values.toList})")
      }

      sc.stop()
    }
  }




