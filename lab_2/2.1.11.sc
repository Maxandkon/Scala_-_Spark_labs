package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("WordsAndLinesExample").setMaster("local")
      val sc = new SparkContext(conf)
      val lines = sc.parallelize(List("hello world", "hi"))
      val words = lines.flatMap(line => line.split(""))
      println("lines -> " + lines.collect.mkString(","))
      println("words -> " + words.collect.mkString(","))
      val wordsSplit = lines.flatMap(line => line.split(" "))
      println("words -> " + wordsSplit.collect.mkString(" , "))

      sc.stop()
    }
  }




