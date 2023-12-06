package LR
import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


  object Main {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("LoadTextFileExample").setMaster("local")
      val sc = new SparkContext(conf)
      val filePath = "D:/date.txt"
      val textFile = sc.textFile(filePath)
      println(s"Кількість рядків у файлі: ${textFile.count()}")

      println("First 5 rows | Перші 5 рядків :")
      textFile.take(5).foreach(println)

      sc.stop()
    }
  }




