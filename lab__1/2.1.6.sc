package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("RemoveDuplicatesExample").setMaster("local")

      val sc = new SparkContext(conf)
      val daysOfWeekRdd = sc.parallelize(Seq(
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
        "Monday", "Wednesday", "Thursday", "Friday"
      ))
      val uniqueDaysRdd = daysOfWeekRdd.distinct()

      println("Uniquer days of Week | Унікальні дні тижня:")
      uniqueDaysRdd.collect().foreach(println)

      sc.stop()
    }
  }




