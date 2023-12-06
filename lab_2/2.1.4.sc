package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("FilterEvenNumbersExample").setMaster("local")

      val sc = new SparkContext(conf)
      val originalRdd = sc.parallelize(2 to 20 by 3)
      val evenRdd = originalRdd.filter(num => num % 2 == 0)

      println("Парні елементи:")
      evenRdd.collect().foreach(println)

      sc.stop()
    }
  }




