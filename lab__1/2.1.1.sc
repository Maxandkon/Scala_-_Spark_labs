package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("CreateRDDExample").setMaster("local")

      val sc = new SparkContext(conf)

      val input_data = List(1, 2, 3, 4, 5, 6, 7)

      val even_rdd = sc.parallelize(input_data.filter(_ % 2 == 0))

      val odd_rdd = sc.parallelize(input_data.filter(_ % 2 != 0))

      println("Even RDD:")
      even_rdd.collect().foreach(println)

      println("Odd RDD:")
      odd_rdd.collect().foreach(println)

      sc.stop()
    }
  }




